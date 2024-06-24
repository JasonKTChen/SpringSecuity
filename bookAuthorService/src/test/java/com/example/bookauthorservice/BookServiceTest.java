package com.example.bookauthorservice;

import com.example.bookauthorservice.domain.entity.Book;
import com.example.bookauthorservice.service.BookService;
import com.example.bookauthorservice.repository.BookRepository;
import com.example.bookauthorservice.repository.CustomBookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CustomBookRepository customBookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindAll() {
        Book book1 = new Book();
        Book book2 = new Book();
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.findAll();
        assertEquals(2, books.size());
    }

    @Test
    public void testFindById() {
        Book book = new Book();
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.findById(1L);
        assertEquals(book, foundBook.orElse(null));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.save(book);
        assertEquals(book, savedBook);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(bookRepository).deleteById(1L);
        bookService.deleteById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }
}
