package lesson06;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime departureDate = LocalDateTime.of(2025, 1, 2, 0, 0);
        Airplane airplane = new Airplane(departureDate);

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

        System.out.println("\nPaid seats\n");
        airplane.getPaidSeats();

        System.out.println("\nReserved seats\n");
        airplane.getReservedSeats();

        System.out.println("\nAvailable seats\n");
        airplane.getAvailableSeats();

        airplane.saveSeatsToFile();

        client1.getSeatInfo(airplane, "A5");
        client1.cancelBook(airplane, "A5");

        airplane.print();

        airplane.saveSeatsToFile();
    }
}
