package com.example.gestionexperiences.controllers;

import com.example.gestionexperiences.dto.ExperienceDto;
import com.example.gestionexperiences.model.Experience;
import com.example.gestionexperiences.service.IExperienceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController implements IExperienceController {

    private final IExperienceService ExperienceService;

    private final ModelMapper mapper;



    @Override
    public ExperienceDto createExperience(ExperienceDto experienceDto) {
        Experience Experience = mapper.map(experienceDto, Experience.class);
        try{
            return mapper.map(ExperienceService.createExperience(Experience), ExperienceDto.class);
        }catch(NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public List<ExperienceDto> getAllExperience() {
        return this.ExperienceService.getAllExperience().stream().map(Experience -> mapper.map(Experience,ExperienceDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public ExperienceDto getOneExperience(Long id) {
        return mapper.map(ExperienceService.getExperience(id), ExperienceDto.class);
    }

    @Override
    public ExperienceDto updateOneExperience(ExperienceDto ExperienceDto) {
        Experience Experience = mapper.map(ExperienceDto,Experience.class);
        return mapper.map(ExperienceService.updateExperience(Experience), ExperienceDto.class);
    }

    @Override
    public void deleteOneExperience(Long id) {
        ExperienceService.removeExperience(id);
    }

    @Override
    public void deleteAllExperience() {
        ExperienceService.removeAllExperience();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RuntimeException ex) {
        return ex.getMessage();
    }
}
