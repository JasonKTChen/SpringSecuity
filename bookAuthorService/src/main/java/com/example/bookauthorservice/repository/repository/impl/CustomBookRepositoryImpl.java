package com.example.bookauthorservice.repository.repository.impl;

import com.example.bookauthorservice.domain.entity.Book;
import com.example.bookauthorservice.repository.CustomBookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomBookRepositoryImpl implements CustomBookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findBooksByTitle(String title) {
        String query = "SELECT b FROM Book b WHERE b.title = :title";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        typedQuery.setParameter("title", title);
        return typedQuery.getResultList();
    }
}
