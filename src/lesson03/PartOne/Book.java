package lesson03.PartOne;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private String status;
    private static List<Book> books = new ArrayList<>();

    public Book(String isbn, String name, String author, int year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = "available";
    }

    public String getBookInfo() {
        return "[" + isbn + "] " + name + " - " + author + " (" + year + "), статус: " + status;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void addNewBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public String reserveBook() {
        if (status.equals("available")) {
            status = "reserved";
            return "Книга '" + name + "' успешно забронирована.";
        } else {
            return "Книга '" + name + "' недоступна для брони (статус: " + status + ").";
        }
    }
}
