package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please provide a title")
    private String title;

    @NotBlank(message = "Please provide an author")
    private String author;

    private int publish_year;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

//    @OneToMany(mappedBy="review", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    private List<Review> reviews;



    public Book(String title, String author, int publish_year) {
        this.title = title;
        this.author = author;
        this.publish_year = publish_year;
    }



    public Book() {

    }

    public static class Builder{
        private Book book;

        public Builder(String title, String author, int publish_year){
            book = new Book(title, author,publish_year);
        }

        public Builder setCreatedAt(Date createdAt) {
            book.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(Date updatedAt) {
            book.updatedAt = updatedAt;
            return this;
        }

        public Book build() {
            return book;
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publish_year;
    }

    public void setPublishYear(int publish_year) {
        this.publish_year = publish_year;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

//    public void add(Review tempReview){
//        if(reviews == null){
//            reviews = new ArrayList<>();
//        }
//
//        reviews.add(tempReview);
//
//        tempReview.setBook(this);
//    }
}
