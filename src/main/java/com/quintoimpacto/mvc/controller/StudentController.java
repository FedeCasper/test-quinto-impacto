package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.CourseRequestDto;
import com.quintoimpacto.mvc.dto.StudentDto;
import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.*;
import com.quintoimpacto.mvc.service.course.CourseService;
import com.quintoimpacto.mvc.service.student.StudentService;
import com.quintoimpacto.mvc.service.user.UserService;
import com.quintoimpacto.mvc.service.userCourse.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private CourseService courseService;

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

    @PostMapping("user_course")
    public ResponseEntity<UserCourse> createUserCourse (@RequestBody CourseRequestDto courseRequestDto, Authentication authentication) {

        User currentUser = userService.getCurrentUser(authentication);
        Course selectedCourse = courseService.getCourseByName(courseRequestDto.getCourseName());

        UserCourse userCourse = new UserCourse();
        if(authentication.getAuthorities().toString().contains("STUDENT")) {
            Student student = (Student) currentUser;
            if (student.getUserCourses().stream().anyMatch( uc ->
                    uc.getCourse().getName().equals(selectedCourse.getName())
            )) {
                throw new RuntimeException("Student already enrolled in this course");
            }

            userCourse = new UserCourse((Student) currentUser, selectedCourse, new Date());
        } else {
            throw new RuntimeException("Invalid user role");
        }

        userCourseService.saveUserCourse(userCourse);
        return ResponseEntity.ok(userCourse);
    }
}
