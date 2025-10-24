package lesson07;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class Seat {
    private String id;
    private SeatClass seatClass;
    private SeatStatus status;
    private Client client;
    private Instant bookingTime;
    private Instant paymentTime;

    public Seat(String id, SeatClass seatClass) {
        this.id = id;
        this.seatClass = seatClass;
        this.status = SeatStatus.AVAILABLE;
        this.client = null;
    }

    public Seat(String id, SeatClass seatClass, SeatStatus status, Client client, Instant bookingTime,
            Instant paymentTime) {
        this.id = id;
        this.seatClass = seatClass;
        this.status = status;
        this.client = client;
        this.bookingTime = bookingTime;
        this.paymentTime = paymentTime;
    }

    public String getId() {
        return id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public Client getClient() {
        return client;
    }

    public Instant getBookingTime() {
        return bookingTime;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBookingTime(Instant bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setPaymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
    }

    public void printSeatInfo() {
        System.out.println("Seat => " +
                "id - " + id +
                ", seatClass - " + seatClass +
                ", status - " + status +
                (client != null ? (", client - " + client.getId() + " " + client.getName()) : "") +
                (bookingTime != null
                        ? ", booking date - "
                                + LocalDate.ofInstant(bookingTime, ZoneId.systemDefault()) + ", booking time - "
                                + LocalTime.ofInstant(bookingTime, ZoneId.systemDefault())
                        : "")
                +
                (paymentTime != null
                        ? ", payment date - "
                                + LocalDate.ofInstant(bookingTime, ZoneId.systemDefault()) + ", payment time - "
                                + LocalTime.ofInstant(bookingTime, ZoneId.systemDefault())
                        : ""));
    }
}
