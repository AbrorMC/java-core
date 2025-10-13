package lesson06;

public class Main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();

        airplane.print();

        Client client1 = new Client("c1", "Ivan Ivanov");
        Client client2 = new Client("c2", "Anna Petrova");
        Client client3 = new Client("c3", "Sergey Semenov");

        client1.getSeatInfo(airplane, "A5");
        client1.book(airplane, "A5");

        client2.getSeatInfo(airplane, "E9");
        client2.book(airplane, "E9");

        client3.getSeatInfo(airplane, "F21");
        client3.book(airplane, "F21");

        System.out.println("\nReserved seats\n");
        airplane.getReservedSeats();

        System.out.println("\nFree seats\n");
        airplane.getFreeSeats();

        airplane.saveSeatsToFile();

        client1.getSeatInfo(airplane, "A5");
        client1.cancelBook(airplane, "A5");

        airplane.print();

        airplane.saveSeatsToFile();
    }
}
