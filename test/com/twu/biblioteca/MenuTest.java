package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cbiggs on 6/17/15.
 */
public class MenuTest {

    private PrintStream printStream;
    private BibliotecaBufferedReader bufferedReader;
    private Menu menu;
    private Biblioteca biblioteca;
    private String quit;
    private String listBooks;
    private String checkOut;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BibliotecaBufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(biblioteca, bufferedReader, printStream);
        listBooks = "1";
        checkOut = "2";
        quit = "3";
    }

    @Test
    public void shouldDisplayWelcomeMessageOnRun(){
        when(bufferedReader.readLine()).thenReturn(quit);
        menu.runMenu();
        verify(printStream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldDisplayMenu() {
        menu.displayMenu();
        verify(printStream).println("1) List Books");
        verify(printStream).println("2) Check Out Book");
        verify(printStream).println("3) Quit");
    }

    @Test
    public void shouldGetUserInput() {
        when(bufferedReader.readLine()).thenReturn(listBooks);
        menu.readInput();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesMenuOptionThatDoesNotExist() {
        when(bufferedReader.readLine()).thenReturn("5");
        menu.selectFromMenu();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReturnInvalidOptionWhenUserChoosesInvalidMenuOption() {
        when(bufferedReader.readLine()).thenReturn("!");
        assertThat(menu.readInput(), is(-1));
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesInvalidMenuOption() {
        when(bufferedReader.readLine()).thenReturn("Turtle").thenReturn(quit);
        menu.selectFromMenu();
        verify(printStream).print("Enter an option: ");
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldPerformSelectionFromMenuWhenRunning() {
        when(bufferedReader.readLine()).thenReturn(listBooks, quit);
        menu.runMenu();
        assertThat(menu.selectFromMenu(), is(false));
    }

    @Test
    public void shouldPromptUserToEnterBookNameWhenUserWantsToCheckOutBook() {
        when(bufferedReader.readLine()).thenReturn(checkOut, quit);

        menu.selectFromMenu();
        verify(printStream).print("Enter an option: ");
        verify(printStream).println("Enter book title: ");
    }
}
