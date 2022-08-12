package com.techelevator.model;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private String isbn;
    private boolean isRead;
    private boolean isFavorited;
    private boolean isCurrentBook;
    private String imgURL;


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public boolean isCurrentBook() {
        return isCurrentBook;
    }

    public void setCurrentBook(boolean currentBook) {
        isCurrentBook = currentBook;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Book() {
    }

    public Book(int bookID, String title, String author, String isbn, boolean isRead, boolean isFavorited, boolean isCurrentBook, String imgURL) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isRead = isRead;
        this.isFavorited = isFavorited;
        this.isCurrentBook = isCurrentBook;
        this.imgURL = imgURL;

    }
}


