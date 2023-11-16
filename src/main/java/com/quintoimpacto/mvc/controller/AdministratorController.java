package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.service.administrator.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Administrator> createAdministrator (@RequestBody UserDto userDto) {
        Administrator newAdministrator = administratorService.createAdministrator(userDto);
        return ResponseEntity.ok(newAdministrator);
    }

}
