package com.example2.demo.biblioteca.repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "isbn")
    private long isbn;
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "book")
    private List<Author2Book> authors = new ArrayList<>();

    public BookEntity() {
    }

    public BookEntity(Long id, long isbn, String title, List<Author2Book> authors) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public List<Author2Book> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author2Book> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", author='" + authors + '\'' +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        BookEntity that = (BookEntity) o;
        return isbn == that.isbn && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(authors, that.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, authors);
    }
}
