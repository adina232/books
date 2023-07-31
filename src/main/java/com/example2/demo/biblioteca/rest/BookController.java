package com.example2.demo.biblioteca.rest;

import com.example2.demo.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/book/delete-book-by-title")
    public void deleteBookByTitle(@RequestParam(value = "title") String title) {
        bookService.deleteBookByTitle(title);
    }

    @DeleteMapping("/book/detele-all-books-by-author")
    public void deleteBooksByAuthor(@RequestParam(value = "author") String nameAuthor) {
        bookService.deleteBooksByAuthor(nameAuthor);
    }

    @PutMapping("/book/modify/{title}")
    public void modifyBookByTitle(@PathVariable String title, @RequestBody Book book) {
        bookService.modifyByTitle(title, book);
    }
}
