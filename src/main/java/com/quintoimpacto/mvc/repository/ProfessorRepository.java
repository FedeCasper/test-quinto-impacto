package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
