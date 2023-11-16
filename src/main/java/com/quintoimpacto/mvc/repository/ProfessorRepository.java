package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
