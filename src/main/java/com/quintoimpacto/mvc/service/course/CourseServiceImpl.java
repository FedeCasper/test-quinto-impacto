package com.quintoimpacto.mvc.service.course;


import com.quintoimpacto.mvc.dto.CourseDto;
import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course createCourse(CourseDto courseDto) {
        if(courseDto == null){
            return null;
        }
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setShift(courseDto.getShift());
        course.setStatus("active");
        return courseRepository.save(course);
    }

    @Override
    public void saveCourse (Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, CourseDto courseDto) {
        Course foundCourse = getCourseById(id);
        if(foundCourse == null){
            return null;
        }
        foundCourse.setName(courseDto.getName());
        foundCourse.setShift(courseDto.getShift());
        return courseRepository.save(foundCourse);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course foundCourse = courseRepository.findById(id).orElse(null);
        if(foundCourse == null){
            return null;
        }
        foundCourse.setStatus("inactive");
        return courseRepository.save(foundCourse);
    }

    @Override
    public Course activateCourse(Long id) {
        Course foundCourse = getCourseById(id);
        if(foundCourse == null){
            return null;
        }
        foundCourse.setStatus("active");
        return courseRepository.save(foundCourse);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findCourseByName(name);
    }
}
