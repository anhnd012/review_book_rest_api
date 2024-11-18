package com.example.demo.rest;

import com.example.demo.entity.Review;
import com.example.demo.service.BookService;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/books/{book_id}/reviews")
public class ReviewRestController {
    private ReviewService reviewService;

    @Autowired
    public ReviewRestController(BookService bookService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public void addReview(@PathVariable int book_id, @RequestBody Review review){
        reviewService.addReview(book_id, review);
    }
}
