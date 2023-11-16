package com.quintoimpacto.mvc.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_courses")
@Getter @Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shift;
    private String status;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourses = new ArrayList<>();

    public Course() {

    }

    public Course(String name, String shift, String status) {
        this.name = name;
        this.shift = shift;
        this.status = status;
    }

}
