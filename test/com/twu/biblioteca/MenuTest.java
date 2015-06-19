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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BibliotecaBufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(biblioteca, bufferedReader, printStream);
    }

    @Test
    public void shouldDisplayMenu() {
        menu.displayMenu();
        verify(printStream).println("1) List Books");
        verify(printStream).println("2) Quit");
    }

    @Test
    public void shouldGetUserInput() {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.readInput();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesMenuOptionThatDoesNotExist() {
        when(bufferedReader.readLine()).thenReturn("0");
        assertThat(menu.readInput(), is(-1));
    }

    @Test
    public void shouldReturnInvalidOptionWhenUserChoosesInvalidMenuOption() {
        when(bufferedReader.readLine()).thenReturn("!");
        assertThat(menu.readInput(), is(-1));
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesInvalidMenuOption() {
        when(bufferedReader.readLine()).thenReturn("Turtle");
        menu.readInput();
        verify(printStream).println("Select a valid option!");
    }
}
