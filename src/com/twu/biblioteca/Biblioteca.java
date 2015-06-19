package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    private List<Book> books;
    private PrintStream printStream;

    Biblioteca(List<Book> books, PrintStream printStream){
        this.books = books;
        this.printStream = printStream;
    }


    public void printListOfBooks() {
        String listofBooks = "";
        for (Book book : books) {
            if( book.checkedIn == true) {
                listofBooks += book.getBookDetails() + "\n";
            }
        }
        printStream.print(listofBooks);
    }
}