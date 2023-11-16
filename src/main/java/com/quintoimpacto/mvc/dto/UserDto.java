package com.quintoimpacto.mvc.dto;

import lombok.*;

import javax.persistence.Column;

@Getter @Setter
public class UserDto {

    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    private String course;
    private String departament;

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

