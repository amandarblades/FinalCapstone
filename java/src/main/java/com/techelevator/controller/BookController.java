package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;
import com.techelevator.model.User;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public BookController(BookDao bookDao, UserDao userDao){
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/addbook/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable String title, Principal principal) throws BookNotFoundException {
        Book book = null;
        book = bookDao.findBookByTitle(title);
        int bookID = book.getBookID();
        System.out.println(bookID);
        String username = getCurrentUsername(principal);
        bookDao.addBookToUser(bookID, username);
        return book;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooksByUsername(Principal principal) {
        List<Book> books = new ArrayList<>();
        String username = getCurrentUsername(principal);

        books = bookDao.findBooksByUsername(username);
        return books;
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }
}
