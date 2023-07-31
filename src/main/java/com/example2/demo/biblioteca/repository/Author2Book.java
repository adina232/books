package com.example2.demo.biblioteca.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "author_2_book")
public class Author2Book implements Serializable {

    @ManyToOne
    @Id
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorEntity author;

    @ManyToOne
    @Id
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    public Author2Book() {
    }

    public Author2Book(AuthorEntity author, BookEntity book) {
        this.author = author;
        this.book = book;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author2Book{" +
                "author=" + author +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author2Book)) return false;
        Author2Book that = (Author2Book) o;
        return Objects.equals(author.getId(), that.author.getId())
                && Objects.equals(book.getId(), that.book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, book);
    }
}
