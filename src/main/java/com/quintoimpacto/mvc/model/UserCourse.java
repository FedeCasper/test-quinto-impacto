package com.quintoimpacto.mvc.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_user_course")
@Getter @Setter
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public UserCourse() {

    }

    public UserCourse(Student student, Course course, Date createAt) {
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public UserCourse(Professor professor, Course course, Date createAt) {
        this.professor = professor;
        this.course = course;
        this.createAt = createAt;
    }


}
