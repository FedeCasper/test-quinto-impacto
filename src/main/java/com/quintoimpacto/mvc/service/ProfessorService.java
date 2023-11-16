package com.quintoimpacto.mvc.service;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Professor;

import java.util.List;

public interface ProfessorService {

    List<Professor> findAll();

    Professor findProfessorById(Long id);

    Professor createProfessor(UserDto userDto);

    void save(Professor professor);

    Professor deleteProfessorById(Long id);

    Professor updateProfessor(Professor professor);

}
