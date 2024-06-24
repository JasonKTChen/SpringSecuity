package com.example.bookauthorservice.repository;

import com.example.bookauthorservice.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthorRepository {
}