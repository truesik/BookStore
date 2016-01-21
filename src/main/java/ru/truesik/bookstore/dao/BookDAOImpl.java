package ru.truesik.bookstore.dao;

import ru.truesik.bookstore.model.Author;
import ru.truesik.bookstore.model.Book;
import ru.truesik.bookstore.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by truesik on 21.01.2016.
 */
public class BookDAOImpl implements BookDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "truesik", "sik666");
    }

    private void closeConnetion(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM BOOK " +
                "INNER JOIN AUTHOR ON BOOK.ID = AUTHOR.BOOK_ID";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("ID"));
                book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                book.setCategoryId(resultSet.getLong("CATEGORY_ID"));
                author.setBookId(resultSet.getLong("BOOK_ID"));
                author.setFirstName(resultSet.getString("FIRST_NAME"));
                author.setLastName(resultSet.getString("LAST_NAME"));
                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("PUBLISHER"));
                result.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnetion(connection);
        }
        return result;
    }

    @Override
    public List<Book> searchBookByKeyword(String keyWord) {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM BOOK " +
                "INNER JOIN AUTHOR ON BOOK.ID = AUTHOR.BOOK_ID " +
                "WHERE BOOK_TITLE LIKE '%" + keyWord.trim() + "%' " +
                "OR FIRST_NAME LIKE '%" + keyWord.trim() + "%' " +
                "OR LAST_NAME LIKE '%" + keyWord.trim() + "%'";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("ID"));
                book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                book.setPublisherName(resultSet.getString("PUBLISHER"));
                author.setFirstName(resultSet.getString("FIRST_NAME"));
                author.setLastName(resultSet.getString("LAST_NAME"));
                author.setBookId(resultSet.getLong("BOOK_ID"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnetion(connection);
        }
        return result;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> result = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM CATEGORY";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("ID"));
                category.setCategoryDescription(resultSet.getString("CATEGORY_DESCRIPTION"));
                result.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnetion(connection);
        }
        return result;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(long bookId) {

    }
}
