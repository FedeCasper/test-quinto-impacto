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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        List<CourseDto> courseDtos = courses.stream().map(CourseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(courseDtos);
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

}
