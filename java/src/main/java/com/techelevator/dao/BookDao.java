package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    public Book findBookByISBN(Long isbn);

    public List<Book> findBooksByUsername(String username);

    public void addBookToUser(int bookID, String username);

    public void deleteBookFromUser(int bookID, int userID);

    //TODO: Get family books
}
