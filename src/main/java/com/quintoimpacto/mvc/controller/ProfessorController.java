package com.quintoimpacto.mvc.controller;

import com.quintoimpacto.mvc.dto.CourseRequestDto;
import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.*;
import com.quintoimpacto.mvc.service.course.CourseService;
import com.quintoimpacto.mvc.service.professor.ProfessorService;
import com.quintoimpacto.mvc.service.user.UserService;
import com.quintoimpacto.mvc.service.userCourse.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professorList =  professorService.getAllProfessors();
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

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Professor> activateStudent (@PathVariable("id") Long id){
        Professor activatedProfessor = professorService.activateProfessor(id);
        return activatedProfessor != null ? ResponseEntity.ok(activatedProfessor) : ResponseEntity.notFound().build();
    }

    @PostMapping("user_course")
    public ResponseEntity<UserCourse> createStudentUserCourse (@RequestBody CourseRequestDto courseRequestDto, Authentication authentication) {

        User currentUser = userService.getCurrentUser(authentication);
        Course selectedCourse = courseService.getCourseByName(courseRequestDto.getCourseName());

        UserCourse userCourse = new UserCourse();
        if(authentication.getAuthorities().toString().contains("PROFESSOR")) {
            Professor professor = (Professor) currentUser;
            if (professor.getUserCourses().stream().anyMatch( uc -> uc.getCourse().getName().equals(selectedCourse.getName())
                    && uc.getCourse().getShift().equals(selectedCourse.getShift()))
            ) {
                throw new RuntimeException("Professor already enrolled in this shift");
            }
            userCourse = new UserCourse((Professor) currentUser, selectedCourse, new Date());
        } else {
            throw new RuntimeException("Invalid user role");
        }

        userCourseService.saveUserCourse(userCourse);
        return ResponseEntity.ok(userCourse);
    }
}
