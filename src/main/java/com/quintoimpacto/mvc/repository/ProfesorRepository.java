package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
