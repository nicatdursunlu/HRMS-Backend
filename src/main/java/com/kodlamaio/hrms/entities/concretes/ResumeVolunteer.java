package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_volunteers")
public class ResumeVolunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_volunteer_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "organization")
    private String organization;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "is_continued")
    private boolean isContinued;

    // relation mapping.
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;
}
