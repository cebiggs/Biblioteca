package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private Biblioteca biblioteca;
    private BibliotecaApp bibliotecaApp;
    private BibliotecaBufferedReader bufferedReader;
    private Menu menu;

    @Before
    public void setUp() {
        bufferedReader = mock(BibliotecaBufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = mock(Menu.class);
        bibliotecaApp = new BibliotecaApp(bufferedReader, menu);
    }

    @Test
    public void shouldDisplayWelcomeMessageOnRun(){
        when(menu.readInput()).thenReturn(2);
        bibliotecaApp.runMenu();
        verify(menu).printWelcomeMessage();
    }

    @Test
    public void shouldStopRunningWhenQuitIsSelectedFromMenu() {
        when(menu.readInput()).thenReturn(1).thenReturn(1).thenReturn(2);
        assertThat(bibliotecaApp.runMenu(), is(true));
    }

    @Test
    public void shouldPerformSelectionFromMenuWhenRunning() {
        when(menu.readInput()).thenReturn(2);
        bibliotecaApp.runMenu();
        verify(menu).selectFromMenu();
    }
}
