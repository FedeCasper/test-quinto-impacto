package com.quintoimpacto.mvc.model;

import lombok.*;

import javax.persistence.*;

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

    public UserCourse() {

    }

    public UserCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public UserCourse(Professor professor, Course course) {
        this.professor = professor;
        this.course = course;
    }

}
