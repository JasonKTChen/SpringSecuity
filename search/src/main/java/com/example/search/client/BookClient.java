package com.example.search.client;

import com.example.search.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "book-author-service")
public interface BookClient {
    @GetMapping("/books")
    List<Book> getAllBooks();

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id);

    @GetMapping("/books/title")
    List<Book> getBooksByTitle(@RequestParam String title);
}
