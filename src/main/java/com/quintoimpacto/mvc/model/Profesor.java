package com.quintoimpacto.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "tbl_profesors")
public class Profesor extends User {

    private String course;

    public Profesor() {
    }

    public Profesor(String name, String lastName, String email, String password, String course) {
        super(name, lastName, email, password);
        this.course = course;
    }
}
