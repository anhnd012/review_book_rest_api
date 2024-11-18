package com.example.demo.rest;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/books")
public class BookRestController {
    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping(path="/{id}")
    public Book getBookById(@PathVariable int id){

        if(id < 0 || bookService.getBookById(id) == null){
            throw new BookNotFoundException("Book id not found - " + id);
        }

        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException (BookNotFoundException exc){

        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        System.out.println(error);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
