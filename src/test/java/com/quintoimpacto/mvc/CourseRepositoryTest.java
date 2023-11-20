package com.quintoimpacto.mvc;

import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFindExistingCourseByName() {
        Course course = courseRepository.findCourseByName("Full Stack Java");
        assertNotNull(course);
        assertEquals("Full Stack Java", course.getName());
    }

    @Test
    public void testFindNonExistingCourseByName() {
        Course nonExistingCourse = courseRepository.findCourseByName("English");
        assertNull(nonExistingCourse);
    }

}