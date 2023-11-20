package com.quintoimpacto.mvc.service.user;

import com.quintoimpacto.mvc.model.User;
import org.springframework.security.core.Authentication;

public interface UserService {

    void saveUser(User user);

    User getCurrentUser(Authentication authentication);

    User getUserByEmail(String email);
}
