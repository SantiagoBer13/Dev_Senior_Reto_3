package com.reto3.model;

public interface IUserRepository {

    void saveUser(User user);
    User findById(String idUser);

}
