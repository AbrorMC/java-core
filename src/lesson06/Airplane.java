package lesson06;

import java.io.*;
import java.util.*;

public class Airplane {
    private final Map<String, Seat> seats = new LinkedHashMap<>();
    private final int minBusinessRow = 1;
    private final int maxBusinessRow = 5;
    private final int firstLimitedReclineRow = 7;
    private final int secondLimitedReclineRow = 21;
    private final static String FILENAME = "src/lesson06/seatsFile.txt";

    public Airplane() {
        initSeats();
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    private void initSeats() {
        if (!loadSeatsFromFile()) {
            generateSeats();
        }
    }

    public void saveSeatsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME)))
        {
            seats.values().stream()
                    .map(s -> "id: " + s.getId() +
                            ", class: " + s.getSeatClass().ordinal() +
                            ", booked: " + s.isBooked() +
                            (s.getClient() != null ? ", client_id: " + s.getClient().getId() : "") +
                            (s.getClient() != null ? ", client_name: " + s.getClient().getName() : "") +
                            "\n")
                    .forEach(s -> {
                        try {
                            bw.write(s);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());;
                        }
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean loadSeatsFromFile() {
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME)))
        {
            String s;
            while ((s = br.readLine()) != null) {
                List<String> record = Arrays.stream(s.split(",")).toList();
                initSeat(record);
                result = true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private void initSeat(List<String> record) {
        Seat seat = new Seat(
                record.get(0).trim().split(" ")[1],
                SeatClass.values()[Integer.parseInt(record.get(1).trim().split(" ")[1])]
        );

        seat.setBooked(Boolean.parseBoolean(record.get(2).trim().split(" ")[1]));

        if (record.size() == 5) {
            Client client = new Client(
                    record.get(3).trim().split(" ")[1],
                    record.get(4).trim().split(" ")[1]
            );
            seat.setClient(client);
        }

        seats.put(seat.getId(), seat);
    }

    private void generateSeats() {
        for (int row = 1; row < 22; row++) {
            generateBusinessSeats(row);
            generateEconomySeats(row);
            generateLimitedReclineSeats(row);
        }
    }

    private void generateBusinessSeats(int row) {
        if (row >= minBusinessRow && row <= maxBusinessRow) {
            Seat seat1 = new Seat("A" + row, SeatClass.BUSINESS_CLASS);
            Seat seat2 = new Seat("C" + row, SeatClass.BUSINESS_CLASS);
            Seat seat3 = new Seat("D" + row, SeatClass.BUSINESS_CLASS);
            Seat seat4 = new Seat("F" + row, SeatClass.BUSINESS_CLASS);

            seats.put(seat1.getId(), seat1);
            seats.put(seat2.getId(), seat2);
            seats.put(seat3.getId(), seat3);
            seats.put(seat4.getId(), seat4);
        }
    }

    private void generateEconomySeats(int row) {
        if (row > maxBusinessRow) {
            char ch = 'A';
            if (row != firstLimitedReclineRow && row != secondLimitedReclineRow) {
                for (int i = 1; i < 7; i++) {
                    seats.put(ch + String.valueOf(row),
                            new Seat(ch + String.valueOf(row), SeatClass.ECONOMY_CLASS));
                    ch++;
                }
            } else if (row == secondLimitedReclineRow) {
                for (int i = 1; i < 7; i++) {
                    if (i != 1 && i != 6) {
                        seats.put(ch + String.valueOf(row),
                                new Seat(ch + String.valueOf(row), SeatClass.ECONOMY_CLASS));
                    }
                    ch++;
                }
            }
        }
    }

    private void generateLimitedReclineSeats(int row) {
        if (row > maxBusinessRow) {
            char ch = 'A';
            if (row == firstLimitedReclineRow) {
                for (int i = 1; i < 7; i++) {
                    seats.put(ch + String.valueOf(row),
                            new Seat(ch + String.valueOf(row), SeatClass.LIMITED_RECLINE));
                    ch++;
                }
            } else {
                for (int i = 1; i < 7; i++) {
                    if (row == secondLimitedReclineRow && (i == 1 || i == 6)) {
                        seats.put(ch + String.valueOf(row),
                                new Seat(ch + String.valueOf(row), SeatClass.LIMITED_RECLINE));
                    }
                    ch++;
                }
            }
        }
    }

    public void getReservedSeats() {
        seats.values().stream()
                .filter(Seat::isBooked)
                .forEach(Seat::printSeatInfo);
    }

    public void getFreeSeats() {
        seats.values().stream()
                .filter(s -> !s.isBooked())
                .forEach(Seat::printSeatInfo);
    }

}
