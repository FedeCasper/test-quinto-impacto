package com.quintoimpacto.mvc.service.user;

import com.quintoimpacto.mvc.model.User;
import org.springframework.security.core.Authentication;

public interface UserService {

    public void saveUser(User user);

    public User getCurrentUser(Authentication authentication);
}
