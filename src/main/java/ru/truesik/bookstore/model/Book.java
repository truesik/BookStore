package ru.truesik.bookstore.model;

import java.util.List;

/**
 * Created by truesik on 21.01.2016.
 */
public class Book {
    private long id;
    private long categoryId;
    private String bookTitle;
    private List<Author> authors;
    private String publisherName;

    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id: " + id +
                ", Book Title: \"" + bookTitle + '\"' +
                '}';
    }
}
