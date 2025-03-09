package com.reto3.model;

public class User {

    private static int idCounter = 0; 
    private String idUser;
    private String name;

    public User(String name) {
        User.idCounter++;
        this.idUser = "U-" + User.idCounter;
        this.name = name;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser.equals(user.idUser) && name.equals(user.name);
    }

}
