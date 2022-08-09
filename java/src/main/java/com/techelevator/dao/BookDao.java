package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    public Book findBookByTitle(String title);

    public List<Book> findBooksByUsername(String username);

    public void addBookToUser(int bookID, int userID);

    public void deleteBookFromUser(int bookID, int userID);


}
