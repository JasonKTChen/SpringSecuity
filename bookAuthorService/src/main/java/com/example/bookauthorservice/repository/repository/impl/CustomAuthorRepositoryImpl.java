package com.example.bookauthorservice.repository.repository.impl;

import com.example.bookauthorservice.repository.CustomAuthorRepository;
import com.example.bookauthorservice.domain.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAuthorsByName(String name) {
        String query = "SELECT a FROM Author a WHERE a.name = :name";
        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList();
    }
}
