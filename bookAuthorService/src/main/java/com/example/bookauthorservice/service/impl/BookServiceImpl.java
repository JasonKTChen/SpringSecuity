package com.example.bookauthorservice.service.impl;

import com.example.bookauthorservice.domain.entity.Book;
import com.example.bookauthorservice.repository.BookRepository;
import com.example.bookauthorservice.repository.CustomBookRepository;
import com.example.bookauthorservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CustomBookRepository customBookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CustomBookRepository customBookRepository) {
        this.bookRepository = bookRepository;
        this.customBookRepository = customBookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findByTitle(String title) {
        return customBookRepository.findBooksByTitle(title);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}