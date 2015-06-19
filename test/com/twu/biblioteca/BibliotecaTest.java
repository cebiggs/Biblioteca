package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    List<Book> books;
    PrintStream printStream;
    Biblioteca biblioteca;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
    }

    @Test
    public void shouldPrintBookNameWhenBibliotecaHasOneBook(){
        Book book = mock(Book.class);
        when(book.getBookDetails()).thenReturn("Book1Details");
        books.add(book);
        biblioteca = new Biblioteca(books, printStream);

        biblioteca.printListOfBooks();

        verify(printStream).print("Book1Details\n");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooksInBiblioteca(){
        biblioteca = new Biblioteca(books, printStream);

        biblioteca.printListOfBooks();

        verify(printStream).print("");
    }

    @Test
    public void shouldPrintTwoBooksWhenThereAreTwoInBiblioteca(){
        Book book1 = mock(Book.class);
        when(book1.getBookDetails()).thenReturn("Book1Details");
        books.add(book1);
        books.add(book1);
        biblioteca = new Biblioteca(books, printStream);

        biblioteca.printListOfBooks();

        verify(printStream).print("Book1Details\nBook1Details\n");
    }

    @Test
    public void shouldOnlyListCheckedInBooksWhenListingBooks() {
        Book book1 = new Book("title1", "author1", "year1", true);
        Book book2 = new Book("title2", "author2", "year2", false);
        books.add(book1);
        books.add(book2);
        biblioteca = new Biblioteca(books, printStream);

        String book1Details = book1.getBookDetails() + "\n";

        biblioteca.printListOfBooks();

        verify(printStream).print(book1Details);
    }
}