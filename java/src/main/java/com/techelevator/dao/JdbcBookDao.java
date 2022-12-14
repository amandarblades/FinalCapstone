package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.BookNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements  BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findBooksByUsername(String username){
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book b JOIN user_book ub ON ub.book_id = b.id JOIN users u ON u.user_id = ub.user_id" +
                " WHERE username = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            books.add(mapRowToBook(results));
        }
        return books;
    }

    @Override
    public void addBookToUser(Book newBook, String username){
        String sqlAddBook = "INSERT INTO book(title, author, isbn, img_url) VALUES(?,?,?,?) RETURNING id";

        Integer bookID = jdbcTemplate.queryForObject(sqlAddBook, Integer.class, newBook.getTitle(), newBook.getAuthor(), newBook.getIsbn(), newBook.getImgURL());

        String sqlAddToUser = "INSERT INTO user_book (user_id, book_id) VALUES ((SELECT user_id FROM users WHERE username= ?), ?);";
        jdbcTemplate.update(sqlAddToUser, username, bookID);
    }

    @Override
    public void deleteBookFromUser(int bookID, int userID){
        String sql = "DELETE FROM user_book WHERE book_id = ? AND user_id = ?;";
        jdbcTemplate.update(sql, bookID, userID);
    }

    @Override
    public Book mapRowToBook(){
        Book book = new Book();
        return book;
    }

    public Book mapRowToBook(SqlRowSet rs){
        Book book = new Book();
        book.setAuthor(rs.getString("author"));
        book.setBookID(rs.getInt("id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setImgURL(rs.getString("img_url"));
        return book;
    }
}