package com.twu.biblioteca;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private Menu menu;
    private BibliotecaBufferedReader bufferedReader;


    BibliotecaApp(BibliotecaBufferedReader bufferedReader, Menu menu){
        this.bufferedReader = bufferedReader;
        this.menu = menu;
    }

    public boolean runMenu(){

        menu.printWelcomeMessage();
        menu.displayMenu();

        while ( menu.selectFromMenu() );

        return true;
    }


    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Go Dog Go", "Dr Suess", "1990"));
        books.add(new Book("Green Eggs and Ham", "Dr Suess", "1991"));
        Biblioteca biblioteca = new Biblioteca(books, System.out);

        InputStreamReader in = new InputStreamReader(System.in);
        BibliotecaBufferedReader bufferedReader = new BibliotecaBufferedReader(in);
        Menu menu = new Menu(biblioteca, bufferedReader, System.out);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bufferedReader, menu);

        bibliotecaApp.runMenu();
    }
}
