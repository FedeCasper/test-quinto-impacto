package com.quintoimpacto.mvc.dto;

import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.model.UserCourse;
import com.quintoimpacto.mvc.rol.UserRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StudentDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private UserRol userRol = UserRol.STUDENT;
    private Date createAt;
    private List<UserCourseDto> userCoursesDto = new ArrayList<>();

    public StudentDto() {
    }

    public StudentDto(Student student) {
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.status = student.getStatus();
        this.userRol = student.getUserRol();
        this.createAt = student.getCreateAt();
        this.userCoursesDto = student.getUserCourses().stream().map(UserCourseDto::new).collect(Collectors.toList());
    }
}
