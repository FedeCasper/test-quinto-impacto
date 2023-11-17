package com.quintoimpacto.mvc.service.student;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(UserDto userDto);

    Student save(Student student);

    Student deleteStudentById(Long id);

    Student updateStudent(Student student);

    Student activateStudent(Long id);

}
