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
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void shouldStopRunningWhenQuitIsSelectedFromMenu() {
        when(menu.readInput()).thenReturn(1).thenReturn(1).thenReturn(2);
        assertThat(menu.runMenu(), is(true));
    }

}
