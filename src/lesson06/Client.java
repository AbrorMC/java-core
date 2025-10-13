package lesson06;

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

            if (!seat.isBooked()) {
                seat.setBooked(true);
                seat.setClient(this);
            }
        }
    }

    public void cancelBook(Airplane airplane, String seatId) {
        if (airplane.getSeats().containsKey(seatId)) {
            Seat seat = airplane.getSeats().get(seatId);

            if (seat.isBooked()) {
                seat.setBooked(false);
                seat.setClient(null);
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
