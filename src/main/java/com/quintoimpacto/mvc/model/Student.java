package com.quintoimpacto.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Student extends User{

    private String course;

    public Student() {

    }

    public Student(String name, String lastName, String email, String password, String course) {
        super(name, lastName, email, password);
        this.course = course;
    }
}
