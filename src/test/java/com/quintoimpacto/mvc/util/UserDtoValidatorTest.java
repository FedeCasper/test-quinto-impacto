package com.quintoimpacto.mvc.util;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.rol.UserRol;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.quintoimpacto.mvc.util.UserDtoValidator.validate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDtoValidatorTest {


    @Test
    public void testValidate_OneFieldIsNull_ReturnsFalse() throws IllegalAccessException {
        UserDto userDto = new UserDto();
        userDto.setName("john");
        userDto.setPassword(null);
        boolean result = validate(userDto);
        assertFalse(result);
    }

    @Test
    public void testValidate_OneFieldIsEmpty_ReturnsFalse() throws IllegalAccessException {
        UserDto userDto = new UserDto();
        userDto.setName("");
        userDto.setPassword("password");
        boolean result = validate(userDto);
        assertFalse(result);
    }

    @Test
    public void testValidate_MultipleFieldsAreNullAndEmpty_ReturnsFalse() throws IllegalAccessException {
        UserDto userDto = new UserDto();
        userDto.setName(null);
        userDto.setPassword("");
        boolean result = validate(userDto);
        assertFalse(result);
    }

}