package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.dto.CourseRequestDto;
import com.quintoimpacto.mvc.model.*;
import com.quintoimpacto.mvc.service.course.CourseService;
import com.quintoimpacto.mvc.service.user.UserService;
import com.quintoimpacto.mvc.service.userCourse.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCourseService userCourseService;


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courseList =  courseService.getAllCourses();
        return courseList != null ? ResponseEntity.ok(courseList) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Course> createCourse (@RequestBody CourseDto courseDto) {
        Course newCourse = courseService.createCourse(courseDto);
        return ResponseEntity.ok(newCourse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Course> deleteCourse (@PathVariable("id") Long id){
        Course deleteCourse = courseService.deleteCourse(id);
        return deleteCourse != null ? ResponseEntity.ok(deleteCourse) : ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <Course> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDto courseDto){
        Course updatedCourse = courseService.updateCourse(id, courseDto);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Course> activateCourse (@PathVariable("id") Long id){
        Course activatedCourse = courseService.activateCourse(id);
        return activatedCourse != null ? ResponseEntity.ok(activatedCourse) : ResponseEntity.notFound().build();
    }

    @PostMapping("user_course")
    public ResponseEntity<UserCourse> createUserCourse (@RequestBody CourseRequestDto courseRequestDto, Authentication authentication) {

        User currentUser = userService.getCurrentUser(authentication);
        Course selectedCourse = courseService.getCourseByName(courseRequestDto.getCourseName());

        UserCourse userCourse = new UserCourse();
        if(authentication.getAuthorities().toString().contains("STUDENT")) {
            userCourse =new UserCourse((Student) currentUser, selectedCourse, new Date());
        } else if(authentication.getAuthorities().toString().contains("PROFESSOR")) {
            userCourse = new UserCourse((Professor) currentUser, selectedCourse, new Date());
        } else {
            throw new RuntimeException("Invalid user role");
        }

        userCourseService.saveUserCourse(userCourse);
        return ResponseEntity.ok(userCourse);
    }
}
