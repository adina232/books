package com.example2.demo.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {


    void deleteByTitle(String title);

//    void deleteByAuthor(String author);

    BookEntity findByTitle(String title);

}
