package com.quintoimpacto.mvc.dto;

import com.quintoimpacto.mvc.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseDto {

    private Long id;
    private String name;
    private String shift;

    public CourseDto() {}

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.shift = course.getShift();
    }

}
