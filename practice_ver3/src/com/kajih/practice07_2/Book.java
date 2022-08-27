package com.kajih.practice07_2;

public class Book {

    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showDetails() {
        System.out.printf("タイトル: %-20s , 著者: %-20s\n", this.title, this.author);
    }

}
