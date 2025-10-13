package lesson06;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class Airplane {
    private final Map<String, Seat> seats = new LinkedHashMap<>();
    private final int minBusinessRow = 1;
    private final int maxBusinessRow = 5;
    private final int rows = 21;
    private final int firstLimitedReclineRow = 7;
    private final int secondLimitedReclineRow = 21;
    private final static String FILENAME = "src/lesson06/seatsFile.txt";

    private LocalDateTime departureDate;

    public Airplane(LocalDateTime departureDate) {
        this.departureDate = departureDate;
        initSeats();
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    private void initSeats() {
        if (!loadSeatsFromFile()) {
            generateSeats();
        }
    }

    public void saveSeatsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            seats.values().stream()
                    .map(s -> "id: " + s.getId() +
                            ", class: " + s.getSeatClass().ordinal() +
                            ", status: " + s.getStatus().ordinal() +
                            (s.getClient() != null ? ", client_id: " + s.getClient().getId() : "") +
                            (s.getClient() != null ? ", client_name: " + s.getClient().getName() : "") +
                            (s.getDateTimeBooking() != null ? ", booking_date_and_time: " + s.getDateTimeBooking() : "")
                            +
                            "\n")
                    .forEach(s -> {
                        try {
                            bw.write(s);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                            ;
                        }
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean loadSeatsFromFile() {
        boolean result = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
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
                SeatClass.values()[Integer.parseInt(record.get(1).trim().split(" ")[1])]);

        seat.setStatus(SeatStatus.values()[Integer.parseInt(record.get(2).trim().split(" ")[1])]);

        if (record.size() == 6) {
            Client client = new Client(
                    record.get(3).trim().split(" ")[1],
                    record.get(4).trim().split(" ")[1] + " " + record.get(4).trim().split(" ")[2]);
            seat.setClient(client);
            Instant dateTimeBooking = Instant.parse(record.get(5).trim().split(" ")[1]);
            seat.setDateTimeBooking(dateTimeBooking);
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
        if (row > maxBusinessRow && row <= rows) {
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
        if (row > maxBusinessRow && row <= rows) {
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

    public void getPaidSeats() {
        seats.values().stream()
                .filter(e -> e.getStatus() == SeatStatus.PAID)
                .forEach(Seat::printSeatInfo);
    }

    public void getReservedSeats() {
        seats.values().stream()
                .filter(e -> e.getStatus() == SeatStatus.BOOKED)
                .forEach(Seat::printSeatInfo);
    }

    public void getAvailableSeats() {
        seats.values().stream()
                .filter(s -> s.getStatus() == SeatStatus.AVAILABLE)
                .forEach(Seat::printSeatInfo);
        System.out.println();
    }

    public void print() {
        System.out.println();
        Seat seat;
        for (int i = 0; i < 6; i++) {
            System.out.printf("%c\t", 'A' + i);
            for (int j = 0; j < rows; j++) {
                if (seats.containsKey("" + (char) ('A' + i) + (int) (j + 1))) {
                    seat = seats.get("" + (char) ('A' + i) + (int) (j + 1));
                    System.out.printf("%s", seat.getSeatClass() == SeatClass.BUSINESS_CLASS ? "[" : "|");
                    System.out.printf("%s", seat.getStatus() == SeatStatus.BOOKED ? "*"
                            : seat.getStatus() == SeatStatus.PAID ? "$" : " ");
                    System.out.printf("%s",
                            seat.getSeatClass() == SeatClass.BUSINESS_CLASS ? "]\t"
                                    : seat.getSeatClass() == SeatClass.LIMITED_RECLINE ? "}\t" : "|\t");
                } else {
                    System.out.print("   \t");
                }
            }
            System.out.println();
        }
        System.out.print("\n\t");
        for (int j = 0; j < rows; j++) {
            System.out.printf(" %d\t", j + 1);
        }
        System.out.println("");
        System.out.println("\nBusiness class => [ ]\tEconomy class => | |\tLimited recline => | }\n");
        System.out.println("");
    }
}
