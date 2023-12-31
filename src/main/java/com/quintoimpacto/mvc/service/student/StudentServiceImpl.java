package com.quintoimpacto.mvc.service.student;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student createStudent(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        User newUser = new User(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
        Student student = new Student(
                newUser.getName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword(),
                "active",
                new Date()
        );

        return studentRepository.save(student);
    }

    @Override
    public Student save(Student student) {
        student.setStatus("active");
        student.setCreateAt(new Date());
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student foundStudent = studentRepository.findById(id).orElse(null);
        foundStudent.setStatus("inactive");
        return studentRepository.save(foundStudent);
    }

    @Override
    public Student updateStudent (Student student) {
        Student foundStudent = getStudentById(student.getId());
        if(foundStudent == null){
            return null;
        }
        foundStudent.setName(student.getName());
        foundStudent.setLastName(student.getLastName());
        foundStudent.setEmail(student.getEmail());
        foundStudent.setPassword(student.getPassword());
        return studentRepository.save(foundStudent);
    }

    @Override
    public Student activateStudent(Long id) {
        Student foundStudent = getStudentById(id);
        if(foundStudent == null){
            return null;
        }
        foundStudent.setStatus("active");
        return studentRepository.save(foundStudent);
    }
}
