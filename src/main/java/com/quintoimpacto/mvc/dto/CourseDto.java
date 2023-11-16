package com.quintoimpacto.mvc.dto;

import lombok.*;
import javax.persistence.*;

@Getter @Setter
public class CourseDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shift;

}
