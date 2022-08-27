package com.kajih.practice07_2;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    public static void main(String[] args) {
        Book[] booksArray = {
                new Book("Effective Java", "Joshua Bloch"),
                new Book("Refactoring", "Martin Fowler"),
                new Book("Clean Coder", "Robert C. Martin"),
                new Book("Domain-Driven Design", "Eric Evans"),
        };
        List<Book> books = new ArrayList<>();
        books.add(booksArray[0]);
        books.add(booksArray[2]);
        books.add(booksArray[3]);

        Library library = new Library(books);
        List<Book> allBooksInLibrary = library.getAllBooksInLibrary();
        for (Book book : allBooksInLibrary) {
            book.showDetails();
        }
    }
}
