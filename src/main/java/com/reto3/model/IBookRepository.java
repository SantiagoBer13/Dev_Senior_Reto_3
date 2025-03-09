package com.reto3.model;

public interface IBookRepository {
    void saveBook(Book book);
    Book findById(String idBook);
}
