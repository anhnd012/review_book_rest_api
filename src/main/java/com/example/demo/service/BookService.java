package com.example.demo.service;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    public void addBook(Book book){
        bookDAO.addBook(book);
    }

    public Book getBookById(int id){
        return bookDAO.getBookById(id);
    }

    public List<Book> getBooks(){
        return bookDAO.getBooks();
    }
}
