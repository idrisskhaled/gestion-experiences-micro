package com.example.gestionexperiences.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExperienceDto {
    @NonNull
    public Long idUser;
    public Date startDate;
    public Date endDate;
    public String positionTitle;
    public String companyName;
}
