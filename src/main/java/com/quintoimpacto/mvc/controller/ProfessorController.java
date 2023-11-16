package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.service.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professorList =  professorService.findAll();
        return professorList != null ? ResponseEntity.ok(professorList) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor (@RequestBody UserDto userDto) {
        Professor newProfessor = professorService.createProfessor(userDto);
        return ResponseEntity.ok(newProfessor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <Professor> updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
        professor.setId(id);
        Professor updatedProfessor = professorService.updateProfessor(professor);
        return updatedProfessor != null ? ResponseEntity.ok(updatedProfessor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Professor> deleteProfessor (@PathVariable("id") Long id){
        Professor deletedProfessor = professorService.deleteProfessorById(id);
        return deletedProfessor != null ? ResponseEntity.ok(deletedProfessor) : ResponseEntity.notFound().build();
    }
}
