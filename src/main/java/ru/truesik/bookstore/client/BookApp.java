package ru.truesik.bookstore.client;

import ru.truesik.bookstore.dao.BookDAO;
import ru.truesik.bookstore.dao.BookDAOImpl;
import ru.truesik.bookstore.model.Book;

import java.util.List;

/**
 * Created by truesik on 21.01.2016.
 */
public class BookApp {
    private static BookDAO bookDAO = new BookDAOImpl();

    public static void main(String[] args) {
        System.out.println("Listing all Books: ");
        findAllBooks();
        System.out.println();

        System.err.println("Search book by keyword in book title: Groovy");
        searchBooks("Groovy");
        System.out.println();

        System.err.println("Search book by keyword in author's name: Josh");
        searchBooks("Josh");
    }

    private static void searchBooks(String keyWord) {
        List<Book> books = bookDAO.searchBookByKeyword(keyWord);
        books.forEach(System.out::println);
    }

    private static void findAllBooks() {
        List<Book> books = bookDAO.findAllBooks();
        books.forEach(System.out::println);
    }
}
