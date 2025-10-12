package lesson06;

public class Seat {
    private String id;
    private SeatClass seatClass;
    private boolean booked;
    private Client client;

    public Seat(String id, SeatClass seatClass) {
        this.id = id;
        this.seatClass = seatClass;
        this.booked = false;
        this.client = null;
    }

    public Seat(String id, SeatClass seatClass, boolean booked, Client client) {
        this.id = id;
        this.seatClass = seatClass;
        this.booked = booked;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public boolean isBooked() {
        return booked;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public Client getClient() {
        return client;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void printSeatInfo() {
        System.out.println("Seat => " +
                "id - " + id +
                ", seatClass - " + seatClass +
                ", booked - " + booked +
                (client != null ? (", client - " + client.getId() + " " + client.getName()) : ""));
    }
}
