package com.quintoimpacto.mvc.configurations;

import com.quintoimpacto.mvc.repository.AdministratorRepository;
import com.quintoimpacto.mvc.repository.ProfessorRepository;
import com.quintoimpacto.mvc.repository.StudentRepository;
import com.quintoimpacto.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(inputName-> {
            com.quintoimpacto.mvc.model.User user = userRepository.findByEmail(inputName);
            if (user != null) {
                String authority;
                if (administratorRepository.existsById(user.getId())) {
                    authority = "ADMIN";
                }
                else if(professorRepository.existsById(user.getId())) {
                    authority = "PROFESSOR";
                }
                else if(studentRepository.existsById(user.getId())) {
                    authority = "STUDENT";
                }
                else {
                    throw new UsernameNotFoundException("Unknown user: " + inputName);
                }
                return new User(user.getEmail(), user.getPassword(),
                        AuthorityUtils.createAuthorityList(authority));
            }
            else {
                throw new UsernameNotFoundException("Unknown user: " + inputName);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}


