package com.quintoimpacto.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "tbl_students")
public class Student extends User{

    private String course;
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Student() {

    }

    public Student(String name, String lastName, String email, String password, String course, String status, Date createAt) {
        super(name, lastName, email, password);
        this.course = course;
        this.status = status;
        this.createAt = createAt;
    }

}
