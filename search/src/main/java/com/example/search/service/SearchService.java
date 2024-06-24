package com.example.search.service;

import com.example.search.domain.Author;
import com.example.search.domain.Book;

import java.util.List;

public interface SearchService {
    List<Book> getAllBooks();
    Book getBookById(Long id);

    List<Book> getBooksByTitle(String title);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);

    List<Author> getAuthorsByName(String name);
}
