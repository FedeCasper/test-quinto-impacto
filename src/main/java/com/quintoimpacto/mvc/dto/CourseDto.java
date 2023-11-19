package com.quintoimpacto.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseDto {

    private String name;
    private String shift;
    private String status;

    public CourseDto() {}

}
