package com.quintoimpacto.mvc.repository;

import com.quintoimpacto.mvc.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
