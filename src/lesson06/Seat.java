package lesson06;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class Seat {
    private String id;
    private SeatClass seatClass;
    private SeatStatus status;
    private Client client;
    private Instant dateTimeBooking;

    public Seat(String id, SeatClass seatClass) {
        this.id = id;
        this.seatClass = seatClass;
        this.status = SeatStatus.AVAILABLE;
        this.client = null;
    }

    public Seat(String id, SeatClass seatClass, SeatStatus status, Client client, Instant dateTimeBooking) {
        this.id = id;
        this.seatClass = seatClass;
        this.status = status;
        this.client = client;
        this.dateTimeBooking = dateTimeBooking;
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

    public Instant getDateTimeBooking() {
        return dateTimeBooking;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDateTimeBooking(Instant dateTimeBooking) {
        this.dateTimeBooking = dateTimeBooking;
    }

    public void printSeatInfo() {
        System.out.println("Seat => " +
                "id - " + id +
                ", seatClass - " + seatClass +
                ", status - " + status +
                (client != null ? (", client - " + client.getId() + " " + client.getName()) : "") +
                (dateTimeBooking != null
                        ? ", booking date - "
                                + LocalDate.ofInstant(dateTimeBooking, ZoneId.systemDefault()) + ", booking time - "
                                + LocalTime.ofInstant(dateTimeBooking, ZoneId.systemDefault())
                        : ""));
    }
}
