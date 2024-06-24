package com.example.bookauthorservice.repository;

import com.example.bookauthorservice.domain.entity.Author;
import java.util.List;

public interface CustomAuthorRepository {
    List<Author> findAuthorsByName(String name);
}
