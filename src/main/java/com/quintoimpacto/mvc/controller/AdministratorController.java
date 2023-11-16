package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.service.administrator.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> administratorList =  administratorService.findAll();
        return administratorList != null ? ResponseEntity.ok(administratorList) : ResponseEntity.notFound().build();
    }

}
