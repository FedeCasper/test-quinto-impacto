package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.StudentDto;
import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentList =  studentService.getAllStudents().stream().map(StudentDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(studentList);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent( @RequestBody UserDto userDto) {
        Student newStudent = studentService.createStudent(userDto);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Student> deleteStudent (@PathVariable("id") Long id){
        Student deletedStudent = studentService.deleteStudentById(id);
        return deletedStudent != null ? ResponseEntity.ok(deletedStudent) : ResponseEntity.notFound().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Student> activateStudent (@PathVariable("id") Long id){
        Student activatedStudent = studentService.activateStudent(id);
        return activatedStudent != null ? ResponseEntity.ok(activatedStudent) : ResponseEntity.notFound().build();
    }
}
