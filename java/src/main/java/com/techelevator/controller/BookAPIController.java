package com.techelevator.controller;

import com.techelevator.model.Book;
import com.techelevator.model.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookAPIController {

    private RestTemplate openLibrary;

    static final String defaultURLRoot = "http://openlibrary.org";
    static final String defaultSearchPath = "/search.json?isbn=";
    static final String defaultWorksPath = ".json";
    static final String defaultSearchURL = "https://openlibrary.org/search.json?q=";

    BookAPIController(){
        this.openLibrary = new RestTemplate();
    }


    @RequestMapping(path="/booksearch/{ISBN}", method= RequestMethod.GET)
    public Book getISBNSearchResult(@PathVariable String ISBN){
        Book returnBook = new Book();

        SearchResult hit = openLibrary.getForObject(defaultURLRoot+ defaultSearchPath + ISBN, SearchResult.class);

        returnBook.setAuthor(hit.getDocs()[0].getAuthor_name()[0]);
        returnBook.setTitle(hit.getDocs()[0].getTitle());
        returnBook.setIsbn(ISBN);
        returnBook.setImageURL("https://covers.openlibrary.org/b/isbn/" + ISBN + "-M.jpg");

        return returnBook;
    }

}

