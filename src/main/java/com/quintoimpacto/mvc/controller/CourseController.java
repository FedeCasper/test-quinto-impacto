package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

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

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Course> activateCourse (@PathVariable("id") Long id){
        Course activatedCourse = courseService.activateCourse(id);
        return activatedCourse != null ? ResponseEntity.ok(activatedCourse) : ResponseEntity.notFound().build();
    }
}
