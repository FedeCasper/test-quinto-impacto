package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent( @RequestBody UserDto userDto) {
        Student newStudent = studentService.createStudent(userDto);
        return ResponseEntity.ok(newStudent);
    }

}
