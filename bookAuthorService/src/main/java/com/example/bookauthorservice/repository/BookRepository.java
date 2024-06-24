package com.example.bookauthorservice.repository;

import com.example.bookauthorservice.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository{
}