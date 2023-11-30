package com.example.gestionexperiences.dao;


import com.example.gestionexperiences.model.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceDao {
    Experience createExperience(Experience experience);
    Optional<Experience> getExperience(Long id);
    Experience updateExperience(Experience experience);
    void removeExperience(Long id);
    void removeAllExperience();
    List<Experience> getAllExperience();
}
