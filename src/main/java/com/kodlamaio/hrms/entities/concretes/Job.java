package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
@EqualsAndHashCode(callSuper = false)
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;

    @JsonIgnore(value = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "created_user_id")
    private int createdUserId;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "state_id")
    private int stateId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "title")
    private String title;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "description")
    private String description;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "jib_title_id")
    private int jobTitleId;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "applicant_quota")
    private BigDecimal applicantQuota;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_application_date")
    private Date lastApplicationDate;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    private State state;

    @JsonIgnore
    @ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_title_id", insertable = false, updatable = false)
    private JobTitle jobTitle;

    @JsonIgnore
    @ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private Employer createdUser;

    @JsonIgnore
    @ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private Employer modifiedUser;
}
