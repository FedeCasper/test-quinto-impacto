package com.quintoimpacto.mvc.service.professor;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Professor;

import java.util.List;

public interface ProfessorService {

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    Professor createProfessor(UserDto userDto);

    void saveProfessor(Professor professor);

    Professor deleteProfessorById(Long id);

    Professor updateProfessor(Professor professor);

    Professor activateProfessor(Long id);

}
