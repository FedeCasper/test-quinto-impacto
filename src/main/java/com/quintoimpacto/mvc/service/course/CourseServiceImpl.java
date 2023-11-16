package com.quintoimpacto.mvc.service.course;

import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public Course createCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public Course updateCourse(Long id, CourseDto courseDto) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
