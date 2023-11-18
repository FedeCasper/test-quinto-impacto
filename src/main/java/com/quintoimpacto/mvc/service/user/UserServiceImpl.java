package com.quintoimpacto.mvc.service.user;

import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
