package com.quintoimpacto.mvc.service;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;


import java.util.List;

public interface AdministratorService {

    List<Administrator> findAll();

    Administrator findAdministratorById(Long id);

    Administrator createAdministrator(UserDto userDto);

    void save(Administrator professor);

    Administrator deleteAdministratorById(Long id);

    Administrator updateAdministrator(Administrator professor);

}
