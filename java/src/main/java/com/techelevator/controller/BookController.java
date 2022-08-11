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

//    @GetMapping(value= "/book")
//    public List<Book> getBook(){
//        String url = "https://openlibrary.org/api/books?bibkeys=ISBN:0451526538&callback=mycallback";
//        RestTemplate restTemplate = new RestTemplate();
//        Book[] book = restTemplate.getForObject(url, Book[].class);
//                return Arrays.asList(book);
//    }

    @GetMapping(value = "/countries")
    public List<Object> getCountries(){
        String url = "https://quoters.apps.pcfone.io/api/random";
        RestTemplate restTemplate = new RestTemplate();

        Object[] countries = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(countries);
    }

    @RequestMapping(value = "/addbook/{isbn}", method = RequestMethod.GET)
    public Book getBookByISBN(@PathVariable long isbn, Principal principal) throws BookNotFoundException {
        Book book = null;
        book = bookDao.findBookByISBN(isbn);
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
