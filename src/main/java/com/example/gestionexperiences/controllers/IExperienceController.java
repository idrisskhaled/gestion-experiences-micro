package com.example.gestionexperiences.controllers;

import com.example.gestionexperiences.dto.ExperienceDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Validated
@RequestMapping("api/experience")
public interface IExperienceController {
    @PostMapping()
    ExperienceDto createExperience(@RequestBody @Valid ExperienceDto experienceDto);

    @GetMapping()
    List<ExperienceDto> getAllExperience();

    @GetMapping("/{id}")
    ExperienceDto getOneExperience(@PathVariable Long id);

    @PutMapping("/{id}")
    ExperienceDto updateOneExperience(@RequestBody @Valid ExperienceDto experienceDto);

    @DeleteMapping("/{id}")
    void deleteOneExperience(@PathVariable Long id);

    @DeleteMapping("")
    void deleteAllExperience();
}
