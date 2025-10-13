package lesson06;

import java.time.Instant;

public class Client {
    private String id;
    private String name;

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void book(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);

            if (seat.getStatus() != SeatStatus.BOOKED && seat.getStatus() != SeatStatus.PAID) {
                seat.setStatus(SeatStatus.BOOKED);
                seat.setClient(this);
                seat.setDateTimeBooking(Instant.now());
            }
        }
    }

    public void cancelBook(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);

            if (seat.getStatus() == SeatStatus.BOOKED) {
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setClient(null);
                seat.setDateTimeBooking(null);
            }
        }
    }

    public void getSeatInfo(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);
            seat.printSeatInfo();
        }
    }

}
