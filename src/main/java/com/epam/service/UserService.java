package com.epam.service;

import com.epam.model.User;

import java.sql.Date;

public interface UserService {

    void create(User user);

    User findById(long id);

    User pollResultById(long id);

    boolean existEmailAndPass(String email, String pass);

    User getByEmailAndPass(String email, String pass);

}
