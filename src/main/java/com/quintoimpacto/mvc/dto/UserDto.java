package com.quintoimpacto.mvc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.rol.UserRol;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Getter @Setter
public class UserDto {

    @JsonIgnore
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    @JsonIgnore
    private String course;
    @JsonIgnore
    private String departament;
    private UserRol userRol;

    List<UserCourseDto> userCourses;

    public UserDto() {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


}

