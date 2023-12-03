package com.example.gestionexperiences.dao;

import com.example.gestionexperiences.dao.repository.ExperienceRepository;
import com.example.gestionexperiences.model.Experience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExperienceDao implements IExperienceDao {

    private final ExperienceRepository experienceRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceDao.class);

    ExperienceDao(ExperienceRepository er){
        this.experienceRepository = er;
    }


    @Override
    public Experience createExperience(Experience Experience) {
        return this.experienceRepository.save(Experience);
    }

    @Override
    public Optional<Experience> getExperience(Long id) {
        return this.experienceRepository.findById(id);
    }

    @Override
    public Experience updateExperience(Experience Experience) {
        return this.experienceRepository.save(Experience);
    }

    @Override
    public void removeExperience(Long id) {
        try{
            this.experienceRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeAllExperience() {
        this.experienceRepository.deleteAll();
    }

    @Override
    public List<Experience> getAllExperience() {
        return this.experienceRepository.findAll();
    }

    @Override
    public List<Experience> getEmployeeExperiences(Long id) {
        return this.experienceRepository.findAllByIdUser(id);
    }
}
