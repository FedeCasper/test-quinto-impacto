package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.UserRepository;
import com.quintoimpacto.mvc.rol.UserRol;
import com.quintoimpacto.mvc.util.UserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>("Genial", HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody UserDto userDto) {
        try {
            if (UserDtoValidator.validate(userDto)) {
                User createdUser;
                UserRol userRole = userDto.getUserRol();

                switch (userRole) {
                    case STUDENT:
                        createdUser = new Student(userDto.getName(), userDto.getLastName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), "", "active", new Date());
                        break;
                    case PROFESSOR:
                        createdUser = new Professor(userDto.getName(), userDto.getLastName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), "", "active", new Date());
                        break;
                    case ADMIN:
                        createdUser = new Administrator(userDto.getName(), userDto.getLastName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), "", "active", new Date());
                        break;
                    default:
                        return null;
                }

                userRepository.save(createdUser);
                return ResponseEntity.ok(createdUser);

            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IllegalAccessException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
