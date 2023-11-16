package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
