package com.reto3.model;

public class Book {

    private static int idCounter = 0; 
    private String idBook;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book( String title, String author) {
        ++Book.idCounter;
        this.idBook = "B-" + Book.idCounter;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getIdBook() {
        return idBook;
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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return idBook.equals(book.idBook) && title.equals(book.title) && author.equals(book.author);
    }
}
