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
@Table(name = "resume_educations")
@EqualsAndHashCode(callSuper = false)
public class ResumeEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_education_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "school_name")
    private String schoolName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "department_name")
    private String departmentName;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "is_graduate")
    private boolean isGraduate;

    @Column(name = "graduate_date")
    private Date graduateDate;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;
}
