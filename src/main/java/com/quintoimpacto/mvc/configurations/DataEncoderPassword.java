package com.quintoimpacto.mvc.configurations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataEncoderPassword {
    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        String rawPassword = "1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}