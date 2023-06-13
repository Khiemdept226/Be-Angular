package com.example.demo.service;

import com.example.demo.Entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService<Student> {

    private final StudentRepository studentRepository;


    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student user) {
        return studentRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        studentRepository.deleteById(id);
    }
}
