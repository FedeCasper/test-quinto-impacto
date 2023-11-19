package com.quintoimpacto.mvc.dto;

import com.quintoimpacto.mvc.model.Course;
import com.quintoimpacto.mvc.model.UserCourse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserCourseDto {

    private Long id;
    private String courseName;
    private String courseShift;
    private Date createAt;

    public UserCourseDto() {
    }

    public UserCourseDto(UserCourse userCourse) {
        this.id = userCourse.getId();
        this.courseName = userCourse.getCourse().getName();
        this.courseShift = userCourse.getCourse().getShift();
        this.createAt = userCourse.getCreateAt();
    }

}
