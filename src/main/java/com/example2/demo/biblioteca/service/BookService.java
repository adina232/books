package com.example2.demo.biblioteca.service;

import com.example2.demo.biblioteca.repository.*;
import com.example2.demo.biblioteca.rest.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        List<AuthorEntity> authors = new ArrayList<>();
        for (String authorName : book.getAuthor()) {
            AuthorEntity authorEntity = authorRepository.findByName(authorName);
            if (authorEntity == null) {
                AuthorEntity newAuthor = new AuthorEntity();
                newAuthor.setName(authorName);
                authorRepository.save(newAuthor);
                authors.add(newAuthor);
            } else {
                authors.add(authorEntity);
            }
        }

        List<Author2Book> author2Books = new ArrayList<>();
        for (AuthorEntity authorEntity : authors) {
            Author2Book author2Book = new Author2Book(authorEntity, bookEntity);
            author2Books.add(author2Book);
        }

        bookEntity.setAuthors(author2Books);
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());

        bookRepository.save(bookEntity);
    }

    public List<Book> getBooks() {
        Iterable<BookEntity> all = bookRepository.findAll();
        List<Book> response = new ArrayList<>();

        for (BookEntity bookEntity : all) {
            Book book = new Book();
            book.setIsbn(bookEntity.getIsbn());
//            book.setAuthor(bookEntity.getAuthor());
            book.setTitle(bookEntity.getTitle());
            response.add(book);
        }
        return response;
    }

    public void deleteBookByTitle(String title) {
        bookRepository.deleteByTitle(title);
    }

    public void deleteBooksByAuthor(String nameAuthor) {
//        bookRepository.deleteByAuthor(nameAuthor);
    }

    public void modifyByTitle(String title, Book book) {
        BookEntity bookEntity = bookRepository.findByTitle(title);


        bookEntity.setTitle(book.getTitle());
//        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setIsbn(book.getIsbn());


        bookRepository.save(bookEntity);

    }
}
