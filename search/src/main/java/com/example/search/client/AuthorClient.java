package com.example.search.client;

import com.example.search.domain.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "book-author-service")
public interface AuthorClient {
    @GetMapping("/authors")
    List<Author> getAllAuthors();

    @GetMapping("/authors/{id}")
    Author getAuthorById(@PathVariable Long id);

    @GetMapping("/authors/name")
    List<Author> getAuthorsByName(@RequestParam String name);
}
