package com.quintoimpacto.mvc.service.course;

import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.model.Professor;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(CourseDto courseDto);

    void saveCourse(Course course);

    Course updateCourse(Long id, CourseDto courseDto);

    Course deleteCourse(Long id);

    Course activateCourse(Long id);
}
