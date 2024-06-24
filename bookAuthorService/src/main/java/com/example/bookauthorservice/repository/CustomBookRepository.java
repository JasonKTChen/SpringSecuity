package com.example.bookauthorservice.repository;

import com.example.bookauthorservice.domain.entity.Book;

import java.util.List;

public interface CustomBookRepository {
    List<Book> findBooksByTitle(String title);
}