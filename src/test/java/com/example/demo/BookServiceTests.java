package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTests {

    Book book;

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setupEach(){
//        book = new Book.Builder("I Feel Bad About My Neck", "sdsdsdsdsdsdsd", 0).build();
        System.out.println("Construct Book instace");
    }

    @Test
    void testNullOrNotNull(){
        Assertions.assertNotNull(bookService.getBookById(1), "Book must not be null");
        Assertions.assertNull(bookService.getBookById(4), "Book must be null");
    }
}
