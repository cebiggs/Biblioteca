package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by dlafeir on 6/17/15.
 */
public class BookTest {

    @Test
    public void shouldFormatBookInfomationWhenGettingDetails(){
        Book book = new Book("Go Dog Go", "Dr. Suess", "1990", true);

        String booksToPrint = book.getBookDetails();

        assertThat(booksToPrint, is("Go Dog Go                 Dr. Suess                 1990"));
    }

    @Test
    public void shouldChangeBookToCheckedInWhenBookIsReturned() {
        boolean checkedIn = false;
        Book book = new Book("title", "author", "year", checkedIn);

        book.checkIn();

        assertEquals(book.checkedIn, true);
    }

    @Test
    public void shouldChangeBookToCheckedOutWhenBookIsCheckedOut() {
        boolean checkedIn = true;
        Book book = new Book("title", "author", "year", checkedIn);

        book.checkOut();

        assertEquals(book.checkedIn, false);
    }
}