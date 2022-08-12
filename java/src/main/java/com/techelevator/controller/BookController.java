package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;
import com.techelevator.model.User;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooksByUsername(Principal principal) {
        List<Book> books = new ArrayList<>();
        String username = getCurrentUsername(principal);

        books = bookDao.findBooksByUsername(username);
        return books;
    }

    //TODO: Implement deleteBookFromUser

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }
}
