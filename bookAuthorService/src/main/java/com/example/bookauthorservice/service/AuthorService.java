package com.example.bookauthorservice.service;

import com.example.bookauthorservice.domain.entity.Author;

import java.util.List;

public interface AuthorService {

    Author save(Author author);
    List<Author> findAll();
    Author findById(Long id);
    void deleteById(Long id);
}
