package com.reto3.model;

import java.util.Date;

public class Loan {

    private final User user;
    private final Book book;
    private final Date date;
    
    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.date = new Date();
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return user.equals(loan.user) && book.equals(loan.book);
    }
    
}
