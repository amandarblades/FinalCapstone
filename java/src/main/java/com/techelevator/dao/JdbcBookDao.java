package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcBookDao implements  BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findBookByTitle(String title){
        Book newBook = null;

        String sqlString = "SELECT * from book where title = ?";
         try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString, title);
            while(results.next()) {
                newBook = mapRowToBook(results);
            }
        } catch (EmptyResultDataAccessException e) {
            throw new BookNotFoundException();
        } if(title == null) throw new IllegalArgumentException("Book title cannot be null");

        return newBook;
    }

    @Override
    public List<Book> findBooksByUsername(String username){return null;}

    @Override
    public void addBookToUser(int bookID, int userID){}

    @Override
    public void deleteBookFromUser(int bookID, int userID){}

    public Book mapRowToBook(SqlRowSet rs){
        Book book = new Book();
        book.setAuthor(rs.getString("author"));
        book.setBookID(rs.getInt("id"));
        book.setIsbn(rs.getLong("isbn"));
        book.setTitle(rs.getString("title"));
        return book;
    }


}

