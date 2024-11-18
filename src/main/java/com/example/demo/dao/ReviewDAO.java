package com.example.demo.dao;

import com.example.demo.entity.Review;

public interface ReviewDAO {
    void addReview(int book_id, Review review);
}
