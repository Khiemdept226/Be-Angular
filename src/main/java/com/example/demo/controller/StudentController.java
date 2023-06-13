package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Student>> getStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student user){
        return new ResponseEntity<>(studentService.save(user), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student user) {
        Optional<Student> userOptional = studentService.findById(id);
        System.out.println(id);
        return userOptional.map(user1 -> {
            user.setId(user1.getId());
            return new ResponseEntity<>(studentService.save(user), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));}
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
            Optional<Student> userOptional = studentService.findById(id);
            return userOptional.map(user-> {
                studentService.remove(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
