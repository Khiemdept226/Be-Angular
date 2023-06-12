package com.example.demo.service;


import com.example.demo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService<T> {


    Iterable<User> findAll();

    Optional<User> findById(Integer id);

    User save(User user);

    void remove(Integer id);
}
