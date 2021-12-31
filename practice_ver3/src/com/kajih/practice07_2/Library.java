package com.kajih.practice07_2;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books = new ArrayList<>();

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllBooksInLibrary() {
        return this.books;
    }

}
