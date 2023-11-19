package com.quintoimpacto.mvc.dto;

import lombok.*;

@Getter @Setter
public class CourseRequestDto {

    private String courseName;
    private String courseShift;

    public CourseRequestDto() {
    }

}
