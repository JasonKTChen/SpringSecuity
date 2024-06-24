package com.example.search.service;

import com.example.search.client.AuthorClient;
import com.example.search.client.BookClient;
import com.example.search.domain.Author;
import com.example.search.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    private final BookClient bookClient;
    private final AuthorClient authorClient;

    @Autowired
    public SearchServiceImpl(BookClient bookClient, AuthorClient authorClient){
        this.bookClient = bookClient;
        this.authorClient = authorClient;
    }
    public List<Book> getAllBooks() {
        return bookClient.getAllBooks();
    }

    public Book getBookById(Long id) {
        return bookClient.getBookById(id);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookClient.getBooksByTitle(title);
    }

    public List<Author> getAllAuthors() {
        return authorClient.getAllAuthors();
    }

    public Author getAuthorById(Long id) {
        return authorClient.getAuthorById(id);
    }

    public List<Author> getAuthorsByName(String name) {
        return authorClient.getAuthorsByName(name);
    }
}