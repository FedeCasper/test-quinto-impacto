package com.quintoimpacto.mvc.service.user;

import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getCurrentUser(Authentication authentication) {
        return userRepository.findByEmail(authentication.getName());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
