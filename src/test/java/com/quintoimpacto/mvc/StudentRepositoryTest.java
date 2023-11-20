package com.quintoimpacto.mvc;


import com.quintoimpacto.mvc.model.Student;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindStudentByIdAndVerifyName() {
        Student student = studentRepository.findById(3L).orElse(null);
        assert student != null;
        assertThat(student.getName()).isEqualTo("Ignacio");
    }

    @Test
    void testListOfNamesByName (){
        List<String> personaList = studentRepository.findAll().stream().map(User::getName).collect(Collectors.toList());
        assertThat(personaList)
                .hasSize(3)
                .contains("Ignacio", "German")
                .doesNotContain("Federico");
    }

}
