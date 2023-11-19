package com.quintoimpacto.mvc.model;

import com.quintoimpacto.mvc.rol.UserRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tbl_students")
public class Student extends User{

    private String course;
    private String status;

    @Column(name = "user_rol")
    @Enumerated(EnumType.STRING)
    private UserRol userRol = UserRol.STUDENT;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<UserCourse> userCourses = new ArrayList<>();

    public Student() {

    }

    public Student(String name, String lastName, String email, String password, String course, String status, Date createAt) {
        super(name, lastName, email, password);
        this.course = course;
        this.status = status;
        this.createAt = createAt;
    }

}
