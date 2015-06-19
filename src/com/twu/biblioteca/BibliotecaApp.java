package com.twu.biblioteca;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Go Dog Go", "Dr Suess", "1990", true));
        books.add(new Book("Green Eggs and Ham", "Dr Suess", "1991", false));
        Biblioteca biblioteca = new Biblioteca(books, System.out);

        InputStreamReader in = new InputStreamReader(System.in);
        BibliotecaBufferedReader bufferedReader = new BibliotecaBufferedReader(in);
        Menu menu = new Menu(biblioteca, bufferedReader, System.out);
        menu.runMenu();
    }
}
