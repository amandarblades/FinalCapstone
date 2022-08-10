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
//        String username =  "Nate"; //getCurrentUsername(principal);
//        bookDao.addBookToUser(bookID, username);
        return book;
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }
}
