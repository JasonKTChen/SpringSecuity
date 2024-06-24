package com.example.search.controller;

import com.example.search.domain.Author;
import com.example.search.domain.Book;
import com.example.search.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search")
public class SearchController {
    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public SearchController(SearchServiceImpl searchServiceImpl){
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = searchServiceImpl.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = searchServiceImpl.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books/title")
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam String title) {
        List<Book> books = searchServiceImpl.getBooksByTitle(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = searchServiceImpl.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = searchServiceImpl.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping("/authors/name")
    public ResponseEntity<List<Author>> getAuthorsByName(@RequestParam String name) {
        List<Author> authors = searchServiceImpl.getAuthorsByName(name);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}
