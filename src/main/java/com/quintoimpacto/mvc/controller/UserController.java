package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.ProfessorDto;
import com.quintoimpacto.mvc.dto.StudentDto;
import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.StudentRepository;
import com.quintoimpacto.mvc.repository.UserRepository;
import com.quintoimpacto.mvc.rol.UserRol;
import com.quintoimpacto.mvc.service.student.StudentService;
import com.quintoimpacto.mvc.service.user.UserService;
import com.quintoimpacto.mvc.util.UserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentService studentService;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        String rol = authentication.getAuthorities().stream().findFirst().get().getAuthority();
        User principal = userService.getUserByEmail(authentication.getName());

        if (rol.equals("STUDENT")) {
            Student student = (Student) principal;
            StudentDto studentDto = new StudentDto(student);
            return ResponseEntity.ok().body(studentDto);
        } else if (rol.equals("PROFESSOR")) {
            Professor professor = (Professor) principal;
            ProfessorDto professorDto = new ProfessorDto(professor);
            return ResponseEntity.ok().body(professorDto);
        } else if (rol.equals("ADMIN")) {
            Administrator administrator = (Administrator) principal;
            return ResponseEntity.ok().body(administrator);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody UserDto userDto) {
        try {
            if (UserDtoValidator.validate(userDto)) {
                User createdUser;
                UserRol userRole = userDto.getUserRol();

                switch (userRole) {
                    case STUDENT:
                        createdUser = new Student(userDto.getName(), userDto.getLastName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), "active", new Date());
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

                userService.saveUser(createdUser);
                return ResponseEntity.ok(createdUser);

            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IllegalAccessException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
