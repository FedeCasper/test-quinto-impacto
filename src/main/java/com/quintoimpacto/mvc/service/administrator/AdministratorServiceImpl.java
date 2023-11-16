package com.quintoimpacto.mvc.service.administrator;

import com.quintoimpacto.mvc.dto.UserDto;
import com.quintoimpacto.mvc.model.Administrator;
import com.quintoimpacto.mvc.model.User;
import com.quintoimpacto.mvc.repository.AdministratorRepository;
import com.quintoimpacto.mvc.service.administrator.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator findAdministratorById (Long id) {
        return administratorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrator createAdministrator(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        User newUser = new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
        Administrator administrator = new Administrator(
                newUser.getName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getPassword(),
                userDto.getDepartament(),
                "active",
                new Date()
        );
        return administratorRepository.save(administrator);
    }

    @Override
    public void save(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public Administrator deleteAdministratorById(Long id) {
        Administrator foundAdministrator = findAdministratorById(id);
        if(foundAdministrator == null){
            return null;
        }
        foundAdministrator.setStatus("inactive");
        return administratorRepository.save(foundAdministrator);
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) {
        Administrator foundAdministrator = findAdministratorById(administrator.getId());
        if(foundAdministrator == null){
            return null;
        }
        foundAdministrator.setName(administrator.getName());
        foundAdministrator.setLastName(administrator.getLastName());
        foundAdministrator.setEmail(administrator.getEmail());
        foundAdministrator.setPassword(administrator.getPassword());
        foundAdministrator.setDepartament(administrator.getDepartament());
        return administratorRepository.save(foundAdministrator);
    }

}
