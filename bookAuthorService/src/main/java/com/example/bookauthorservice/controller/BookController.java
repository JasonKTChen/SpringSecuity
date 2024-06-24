package com.example.bookauthorservice.controller;

import com.example.bookauthorservice.domain.dto.AuthorDto;
import com.example.bookauthorservice.domain.dto.BookDto;
import com.example.bookauthorservice.domain.entity.Author;
import com.example.bookauthorservice.domain.entity.Book;
import com.example.bookauthorservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return convertToDto(bookService.findById(id));
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = convertToEntity(bookDto);
        return convertToDto(bookService.save(book));
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book book = bookService.findById(id);
        book.setTitle(bookDto.getTitle());
        book.setAuthors(bookDto.getAuthors().stream().map(this::convertToEntity).collect(Collectors.toSet()));
        return convertToDto(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    private BookDto convertToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthors(book.getAuthors().stream().map(this::convertToDto).collect(Collectors.toSet()));
        return bookDto;
    }

    private Book convertToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthors(bookDto.getAuthors().stream().map(this::convertToEntity).collect(Collectors.toSet()));
        return book;
    }

    private AuthorDto convertToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }

    private Author convertToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        return author;
    }
}
