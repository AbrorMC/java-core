package lesson07;

import java.time.Instant;
import java.util.Objects;

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
                seat.setBookingTime(Instant.now());
            }
        }
    }

    public void pay(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);

            if (seat.getStatus() == SeatStatus.BOOKED && seat.getClient().equals(this)) {
                seat.setStatus(SeatStatus.PAID);
                seat.setPaymentTime(Instant.now());
            }
        }
    }

    public void cancelBook(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);

            if (seat.getStatus() == SeatStatus.BOOKED) {
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setClient(null);
                seat.setBookingTime(null);
                ;
            }
        }
    }

    public void getSeatInfo(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);
            seat.printSeatInfo();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
