package com.quintoimpacto.mvc.service.administrator;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.Professor;


import java.util.List;

public interface AdministratorService {

    List<Administrator> getAllAdministrators ();

    Administrator getAdministratorById(Long id);

    Administrator createAdministrator(UserDto userDto);

    void saveAdministrator(Administrator professor);

    Administrator deleteAdministratorById(Long id);

    Administrator updateAdministrator(Administrator professor);

    Administrator activateAdministrator(Long id);
}
