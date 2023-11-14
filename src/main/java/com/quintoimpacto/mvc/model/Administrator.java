package com.quintoimpacto.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "tbl_administrators")
public class Administrator extends User {

    private String departament;

    public Administrator() {

    }

    public Administrator(String name, String lastName, String email, String password, String departament) {
        super(name, lastName, email, password);
        this.departament = departament;
    }
}
