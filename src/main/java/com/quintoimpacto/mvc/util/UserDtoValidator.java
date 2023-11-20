package com.quintoimpacto.mvc.util;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quintoimpacto.mvc.dto.UserDto;

public class UserDtoValidator {

    public static boolean validate(UserDto userDto) throws IllegalAccessException {
        Field[] fields = UserDto.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonIgnore.class)) {
                continue; // Ignorar propiedades marcadas con @JsonIgnore
            }
            field.setAccessible(true);
            Object value = field.get(userDto);
            if (value == null || value.toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}