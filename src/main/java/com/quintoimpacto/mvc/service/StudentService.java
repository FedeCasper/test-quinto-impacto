package com.quintoimpacto.mvc.service;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findStudentById(Long id);

    Student createStudent(UserDto userDto);

    Student save(Student student);

    Student deleteStudentById(Long id);

    Student updateStudent(Student student);

}
