package com.example2.demo.biblioteca.rest;

import com.example2.demo.biblioteca.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookControllerTest {
    BookService bookService = mock(BookService.class);
    BookController bookController = new BookController(bookService);
    @Test
    void addBook() {
        Book book = new Book();
        bookController.addBook(book);
        verify(bookService).addBook(book);
    }

    @Test
    void getBooks() {
        List<Book> result = bookController.getBooks();
        assertEquals(result, bookService.getBooks());
    }

    @Test
    void deleteBookByTitle() {
        bookController.deleteBookByTitle("test");
        verify(bookService).deleteBookByTitle("test");
    }

    @Test
    void deleteBooksByAuthor() {
        bookController.deleteBooksByAuthor("test");
        verify(bookService).deleteBooksByAuthor("test");
    }

    @Test
    void modifyBookByTitle() {
        Book book = new Book();
        bookController.modifyBookByTitle("test", book);
        verify(bookService).modifyByTitle("test", book);
    }
}