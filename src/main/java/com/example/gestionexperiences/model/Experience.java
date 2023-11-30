package com.example.gestionexperiences.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "T_EXPERIENCE")
@Getter
@Setter
public class Experience extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experience")
    private Long idExperience;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "postition_title")
    private String positionTitle;

    @Column(name = "company_name")
    private String companyName;

}
