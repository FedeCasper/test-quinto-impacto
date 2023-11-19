package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findCourseByName(String name);

}
