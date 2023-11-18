package com.quintoimpacto.mvc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quintoimpacto.mvc.rol.UserRol;
import lombok.*;

import javax.persistence.Column;

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

    public UserDto() {

    }

    public UserDto(Long id, String name, String lastName, String email, String password, String course) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.course = course;
    }


}

