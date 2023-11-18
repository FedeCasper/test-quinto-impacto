package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByEmail(String email);
}
