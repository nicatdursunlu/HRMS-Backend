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
@Table(name = "resume_certificates")
public class ResumeCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_certificate_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "organization")
    private String organization;

    @Column(name = "degree")
    private String degree;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "given_date")
    private Date givenDate;

    @Column(name = "end_date")
    private Date endDate;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "is_limitless")
    private boolean isLimitless;

    // relation mapping.
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;
}
