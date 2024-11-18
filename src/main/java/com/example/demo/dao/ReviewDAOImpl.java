package com.example.demo.dao;

import com.example.demo.entity.Book;
import com.example.demo.entity.Review;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
    private EntityManager entityManager;

    @Autowired
    public ReviewDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void addReview(int book_id, Review review){
        Book book = entityManager.find(Book.class, book_id);
//        book.add(review);
        entityManager.persist(review);
    }



}
