package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Course> activateCourse (@PathVariable("id") Long id){
        Course activatedCourse = courseService.activateCourse(id);
        return activatedCourse != null ? ResponseEntity.ok(activatedCourse) : ResponseEntity.notFound().build();
    }
}
