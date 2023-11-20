package com.quintoimpacto.mvc.service.userCourse;

import com.quintoimpacto.mvc.model.UserCourse;
import com.quintoimpacto.mvc.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public void saveUserCourse(UserCourse userCourse) {
        userCourseRepository.save(userCourse);
    }

}
