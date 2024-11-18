package com.example.demo.dao;

import com.example.demo.entity.Book;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BookDAO {

    List<Book> getBooks();

    Book getBookById(int id);

    void addBook(Book book);
}
