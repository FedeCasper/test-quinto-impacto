package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
}
