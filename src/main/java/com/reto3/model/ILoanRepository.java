package com.reto3.model;

import java.util.List;

public interface ILoanRepository {

    void saveLoan(Loan loan);
    List<Loan> findByUserId(String idUser);

}
