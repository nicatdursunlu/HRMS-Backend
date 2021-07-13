package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "resume_experiences")
@EqualsAndHashCode(callSuper = false)
public class ResumeExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_experience_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "company_name")
    private String companyName;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "job_title_id")
    private int jobTitleId;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "is_continued")
    private boolean continued;

    @Column(name = "end_date")
    private Date endDate;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @JsonIgnore
    @ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_title_id", insertable = false, updatable = false)
    private JobTitle jobTitle;
}
