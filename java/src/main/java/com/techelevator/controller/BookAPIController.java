package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@RestController
@CrossOrigin
public class BookAPIController {

    private RestTemplate openLibrary;

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    static final String defaultURLRoot = "http://openlibrary.org";
    static final String defaultSearchPath = "/search.json?isbn=";
    static final String defaultWorksPath = ".json";
    static final String defaultSearchURL = "https://openlibrary.org/search.json?q=";

    BookAPIController(){
        this.openLibrary = new RestTemplate();
    }


    @RequestMapping(path="/addbook/{ISBN}", method= RequestMethod.GET)
    public Book getISBNSearchResult(@PathVariable String ISBN, Principal principal){
        Book returnBook = new Book();

        SearchResult hit = openLibrary.getForObject(defaultURLRoot+ defaultSearchPath + ISBN, SearchResult.class);

        returnBook.setAuthor(hit.getDocs()[0].getAuthor_name()[0]);
        returnBook.setTitle(hit.getDocs()[0].getTitle());
        returnBook.setIsbn(ISBN);
        returnBook.setImageURL("https://covers.openlibrary.org/b/isbn/" + ISBN + "-M.jpg");

        String username = "Nate"; //getCurrentUsername(principal);

        bookDao.addBookToUser(returnBook, username);

        return returnBook;
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();
    }

}

