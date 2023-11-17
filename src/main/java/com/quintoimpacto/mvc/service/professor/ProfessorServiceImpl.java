package com.quintoimpacto.mvc.service.professor;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public Professor createProfessor(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        User newUser = new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
        Professor professor = new Professor(
                newUser.getName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword(),
                userDto.getCourse(),
                "active",
                new Date()
        );
        return professorRepository.save(professor);
    }

    @Override
    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Professor deleteProfessorById(Long id) {
        Professor foundProfessor = getProfessorById(id);
        if(foundProfessor == null){
            return null;
        }
        foundProfessor.setStatus("inactive");
        return professorRepository.save(foundProfessor);
    }

    @Override
    public Professor updateProfessor(Professor professor) {
        Professor foundProfessor = getProfessorById(professor.getId());
        if(foundProfessor == null){
            return null;
        }
        foundProfessor.setName(professor.getName());
        foundProfessor.setLastName(professor.getLastName());
        foundProfessor.setEmail(professor.getEmail());
        foundProfessor.setPassword(professor.getPassword());
        foundProfessor.setCourse(professor.getCourse());
        return professorRepository.save(foundProfessor);
    }

    @Override
    public Professor activateProfessor(Long id) {
        Professor foundProfessor = getProfessorById(id);
        if(foundProfessor == null){
            return null;
        }
        foundProfessor.setStatus("active");
        return professorRepository.save(foundProfessor);
    }
}
