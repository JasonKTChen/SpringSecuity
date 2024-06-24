package com.example.bookauthorservice.service.impl;

import com.example.bookauthorservice.domain.entity.Author;
import com.example.bookauthorservice.exception.ResourceNotFoundException;
import com.example.bookauthorservice.repository.AuthorRepository;
import com.example.bookauthorservice.repository.CustomAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl {
    private final AuthorRepository authorRepository;
    private final CustomAuthorRepository customAuthorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, CustomAuthorRepository customAuthorRepository) {
        this.authorRepository = authorRepository;
        this.customAuthorRepository = customAuthorRepository;
    }
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> findByName(String name) {
        return authorRepository.findAuthorsByName(name);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}


