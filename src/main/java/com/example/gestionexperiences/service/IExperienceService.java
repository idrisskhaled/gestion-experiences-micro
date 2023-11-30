package com.example.gestionexperiences.service;

import com.example.gestionexperiences.model.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {
    Experience createExperience(Experience Experience);
    Experience updateExperience(Experience Experience);
    Optional<Experience> getExperience(Long id);
    List<Experience> getAllExperience();
    void removeExperience(Long id);
    void removeAllExperience();
}
