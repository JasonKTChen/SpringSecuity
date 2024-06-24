package com.example.bookauthorservice.service;

import com.example.bookauthorservice.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findByTitle(String title);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void deleteById(Long id);
    Book save(Book book);
}
