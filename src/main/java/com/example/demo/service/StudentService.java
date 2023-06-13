package com.example.demo.service;


import com.example.demo.Entity.Student;

import java.util.Optional;

public interface StudentService<T> {


    Iterable<Student> findAll();

    Optional<Student> findById(Integer id);

    Student save(Student user);

    void remove(Integer id);
}
