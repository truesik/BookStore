package ru.truesik.bookstore.dao;

import ru.truesik.bookstore.model.Book;
import ru.truesik.bookstore.model.Category;

import java.util.List;

/**
 * Created by truesik on 21.01.2016.
 */
public interface BookDAO {
    List<Book> findAllBooks();

    List<Book> searchBookByKeyword(String keyword);

    List<Category> findAllCategories();

    void insert(Book book);

    void update(Book book);

    void delete(long bookId);
}
