package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java: The Complete Reference", 1248);
        Book book2 = new Book("Clean code", 464);
        Book book3 = new Book("Effective Java", 416);
        Book book4 = new Book("Head First Java", 720);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        getAllBooks(books);

        swapBooks(books, 0, 3);
        getAllBooks(books);

        getBookByName(books, "Clean code");
    }

    private static void getBookByName(Book[] books, String name) {
        for (Book book : books) {
            if (Objects.equals(name, book.getName())) {
                System.out.printf("""
                        Book {
                            "name" : "%s",
                            "page_count" : "%s"
                        }
                        """, book.getName(), book.getPageCount());
            }
        }
    }

    private static void swapBooks(Book[] books, int first, int second) {
        System.out.printf("Swap books for indexes %d and %d%n", first, second);
        Book temp = books[first];
        books[first] = books[second];
        books[second] = temp;
    }

    private static void getAllBooks(Book[] books) {
        for (Book book : books) {
            System.out.printf("""
                    Book {
                        "name" : "%s",
                        "page_count" : "%s"
                    }
                    """, book.getName(), book.getPageCount());
        }
    }
}
