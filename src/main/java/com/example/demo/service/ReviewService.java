package com.example.demo.service;

import com.example.demo.dao.ReviewDAO;
import com.example.demo.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewDAO reviewDAO;

    @Autowired
    public ReviewService(ReviewDAO reviewDAO){
        this.reviewDAO = reviewDAO;
    }

    public void addReview(int book_id, Review review){
        reviewDAO.addReview(book_id, review);
    };
}
