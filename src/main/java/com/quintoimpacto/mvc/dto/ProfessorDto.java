package com.quintoimpacto.mvc.dto;

import com.quintoimpacto.mvc.model.Professor;
import com.quintoimpacto.mvc.rol.UserRol;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class ProfessorDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private UserRol userRol = UserRol.STUDENT;
    private Date createAt;
    private List<UserCourseDto> userCoursesDto = new ArrayList<>();

    public ProfessorDto() {
    }

    public ProfessorDto(Professor professor) {
        this.name = professor.getName();
        this.lastName = professor.getLastName();
        this.email = professor.getEmail();
        this.password = professor.getPassword();
        this.status = professor.getStatus();
        this.userRol = professor.getUserRol();
        this.createAt = professor.getCreateAt();
        this.userCoursesDto = professor.getUserCourses().stream().map(UserCourseDto::new).collect(Collectors.toList());
    }

}
