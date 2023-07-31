package com.example2.demo.biblioteca.service;

import com.example2.demo.biblioteca.repository.*;
import com.example2.demo.biblioteca.rest.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class BookServiceTest {
    BookRepository bookRepository = mock(BookRepository.class);
    AuthorRepository authorRepository = mock(AuthorRepository.class);
    BookService bookService = new BookService(bookRepository, authorRepository);

    @Test
    void addBook_whenAuthorEntityIsNotNull_expectToSaveBookEntityWithGivenAuthor() {
        Book book = new Book();
        book.setTitle("Test");
        book.setIsbn(123);

        List<String> authorEntityList = new ArrayList<>();
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("Author");
        authorEntity.setId(1L);
        authorEntityList.add(authorEntity.getName());

        book.setAuthor(authorEntityList);

        when(authorRepository.findByName("Author")).thenReturn(authorEntity);

        bookService.addBook(book);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());

        List<Author2Book> author2Books = new ArrayList<>();
        Author2Book author2Book = new Author2Book(authorEntity, bookEntity);
        author2Books.add(author2Book);
        bookEntity.setAuthors(author2Books);

        verify(bookRepository).save(bookEntity);
    }

    @Test
    void addBook_whenAuthorEntityIsNull_expectToGiveAuthor() {
        Book book = new Book();
        book.setIsbn(123);
        book.setTitle("Test");
        List<String> authorEntityNameList = new ArrayList<>();
        authorEntityNameList.add("Author");
        book.setAuthor(authorEntityNameList);

        when(authorRepository.findByName("Test")).thenReturn(null);
        bookService.addBook(book);

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("Author");
        authorEntity.setId(null);
        verify(authorRepository).save(authorEntity);

        authorEntityNameList.add(authorEntity.getName());
        book.setAuthor(authorEntityNameList);

        List<Author2Book> author2Books = new ArrayList<>();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        Author2Book author2Book = new Author2Book(authorEntity, bookEntity);
        author2Books.add(author2Book);
        bookEntity.setAuthors(author2Books);
        verify(bookRepository).save(bookEntity);
    }

    @Test
    void getBooks() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("Test");
        bookEntity.setIsbn(123);
        bookEntity.setId(1L);

        List<BookEntity> all = new ArrayList<>();
        all.add(bookEntity);

        when(bookRepository.findAll()).thenReturn(all);

        List<Book> result = bookService.getBooks();

        assertEquals("Test", result.get(0).getTitle());
        assertEquals(123, result.get(0).getIsbn());
    }

    @Test
    void deleteBookByTitle() {
        bookService.deleteBookByTitle("Test");
        verify(bookRepository).deleteByTitle("Test");
    }

    @Test
    void modifyByTitle() {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("Initial");
        bookEntity.setIsbn(1111);

        when(bookRepository.findByTitle("Initial")).thenReturn(bookEntity);

        Book book = new Book();
        book.setIsbn(1234);
        book.setTitle("Final");

        bookService.modifyByTitle("Initial", book);

        verify(bookRepository).save(bookEntity);
    }
}