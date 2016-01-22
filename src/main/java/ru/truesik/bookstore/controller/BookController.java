package ru.truesik.bookstore.controller;

import ru.truesik.bookstore.dao.BookDAO;
import ru.truesik.bookstore.dao.BookDAOImpl;
import ru.truesik.bookstore.model.Book;
import ru.truesik.bookstore.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by truesik on 22.01.2016.
 */
public class BookController extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BookDAO bookDAO = new BookDAOImpl();
        List<Category> categoryList = bookDAO.findAllCategories();
        ServletContext context = config.getServletContext();
        context.setAttribute("categoryList", categoryList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String base = "/jsp/";
        String url = base + "home.jsp";
        String action = request.getParameter("action");
        String category = request.getParameter("category");
        String keyWord = request.getParameter("keyWord");
        if (action != null) {
            switch (action) {
                case "allBooks":
                    findAllBooks(request, response);
                    url = base + "listOfBooks.jsp";
                    break;
                case "category":
                    findAllBooks(request, response);
                    url = base + "category.jsp?category=" + category;
                    break;
                case "search":
                    searchBooks(request, response, keyWord);
                    url = base + "searchResult.jsp";
                    break;
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyWord) {
        BookDAO bookDAO = new BookDAOImpl();
        List<Book> bookList = bookDAO.searchBookByKeyword(keyWord);
        request.setAttribute("bookList", bookList);
    }

    private void findAllBooks(HttpServletRequest request, HttpServletResponse response) {
        BookDAO bookDAO = new BookDAOImpl();
        List<Book> bookList = bookDAO.findAllBooks();
        request.setAttribute("bookList", bookList);
    }

}
