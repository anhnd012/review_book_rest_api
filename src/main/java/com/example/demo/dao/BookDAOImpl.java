package com.example.demo.dao;

import com.example.demo.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void addBook(Book book){
        entityManager.persist(book);
    }

    @Override
    public Book getBookById(int id){
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getBooks(){
        TypedQuery<Book> books = entityManager.createQuery("From Book", Book.class);
        return books.getResultList();
    }
}
