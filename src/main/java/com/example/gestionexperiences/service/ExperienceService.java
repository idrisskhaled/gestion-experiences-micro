package com.example.gestionexperiences.service;

import com.example.gestionexperiences.dao.IExperienceDao;
import com.example.gestionexperiences.dto.EmployeDto;
import com.example.gestionexperiences.model.Experience;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IExperienceService {

    private final IExperienceDao experienceDao;
    private final RestTemplate restTemplate;


    ExperienceService(IExperienceDao ed, RestTemplate restTemplate){
        this.experienceDao = ed;
        this.restTemplate = restTemplate;
    }


    public boolean doesEmployeeExist(Long employeeId) {

        String employeeServiceUrl = "http://localhost:8080/api/user/employee/" + employeeId;
        EmployeDto employe = restTemplate.getForObject(employeeServiceUrl, EmployeDto.class);
        if(employe == null) return false;
        return true;
    }

    @Override
    public Experience createExperience(Experience experience) {
        if(!doesEmployeeExist(experience.getIdUser())){
            throw new NotFoundException("Employee not found !");
        }
        return this.experienceDao.createExperience(experience);
    }

    @Override
    public Experience updateExperience(Experience experience) {
        return this.experienceDao.createExperience(experience);
    }

    @Override
    public Optional<Experience> getExperience(Long id) {

        return this.experienceDao.getExperience(id);


    }

    @Override
    public List<Experience> getAllExperience() {
        return this.experienceDao.getAllExperience();
    }

    @Override
    public void removeExperience(Long id) {
        this.experienceDao.removeExperience(id);
    }

    @Override
    public void removeAllExperience() {
        this.experienceDao.removeAllExperience();
    }
}
