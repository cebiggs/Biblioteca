package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbiggs on 6/17/15.
 */
public class Menu {

    private BibliotecaBufferedReader bufferedReader;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    public Menu(Biblioteca biblioteca, BibliotecaBufferedReader bufferedReader, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public boolean runMenu(){

        printWelcomeMessage();
        displayMenu();

        while ( selectFromMenu() );

        return true;
    }

    public void displayMenu() {
        printStream.println("1) List Books");
        printStream.println("2) Check Out Book");
        printStream.println("3) Quit");
    }

    public int readInput(){
        printStream.print("Enter an option: ");

        int input;

        try {
            input = Integer.parseInt(bufferedReader.readLine());

        } catch (NumberFormatException numFormatException) {
            input = -1;
        }

        return input;
    }

    public boolean selectFromMenu() {
        boolean keepMenuRunning = true;

        int input = readInput();

        if(input == 1){
            biblioteca.printListOfBooks();
        }
        else if(input == 2){
            printStream.println("Enter book title: ");
        }
        else if(input == 3){
            keepMenuRunning = false;
        }
        else {
            printStream.println("Select a valid option!");
        }
        return keepMenuRunning;
    }


    public void printWelcomeMessage() {
        printStream.println("Welcome to the Biblioteca!");
    }

}
