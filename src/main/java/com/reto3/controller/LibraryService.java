package com.reto3.controller;

import java.util.List;

import com.reto3.model.Book;
import com.reto3.model.IBookRepository;
import com.reto3.model.ILoanRepository;
import com.reto3.model.IUserRepository;
import com.reto3.model.Loan;
import com.reto3.model.User;

public class LibraryService {

    private IBookRepository iBookRepository;
    private ILoanRepository iLoanRepository;
    private IUserRepository iUserRepository;

    public LibraryService(IBookRepository iBookRepository, ILoanRepository iLoanRepository, IUserRepository iUserRepository) {
        this.iBookRepository = iBookRepository;
        this.iLoanRepository = iLoanRepository;
        this.iUserRepository = iUserRepository;
    }

    public void addBook(String title, String author){
        if(title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Title and author cannot be empty");
        }
        Book book = new Book(title, author);
        iBookRepository.saveBook(book);
    }

    public Book getBookById(String idBook){
        return iBookRepository.findById(idBook);
    }

    public void addUser(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("User name cannot be empty");
        }
        iUserRepository.saveUser(new User(name));
    }

    public void createLoan(User user, Book book){
        if(user == null || book == null){
            throw new IllegalArgumentException("User and Book cannot be null");
        }
        this.iLoanRepository.saveLoan(new Loan(user, book));
    }

    public List<Loan> getLoansByUserId(String idUser){
        return this.iLoanRepository.findByUserId(idUser);
    }
}