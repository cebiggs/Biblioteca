package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String author;
    private String year;
    public boolean checkedIn;

    public Book(String bookName, String author, String year, boolean checkedIn) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.checkedIn = checkedIn;
    }

    public String getBookDetails() {
        return String.format("%-25s %-25s %s",bookName,author,year);
    }

    public void checkIn() {
        checkedIn = true;
    }

    public void checkOut() {
        checkedIn = false;
    }
}
