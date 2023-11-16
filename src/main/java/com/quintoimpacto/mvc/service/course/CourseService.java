package com.quintoimpacto.mvc.service.course;

import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(CourseDto courseDto);

    Course updateCourse(Long id, CourseDto courseDto);

    void deleteCourse(Long id);
}
