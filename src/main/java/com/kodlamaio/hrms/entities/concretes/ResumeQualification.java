package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "resume_qualifications")
public class ResumeQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_qualification_id")
    private int id;

    @Column(name = "resume_id")
    @NotNull(message = ValidationMessages.NOT_BLANK)
    private int resumeId;

    @Column(name = "qualification_id")
    @NotNull(message = ValidationMessages.NOT_BLANK)
    private int qualificationId;

    @Column(name = "grade")
    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
    private BigDecimal grade;

    // relation
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @JsonIgnore
    @ManyToOne(targetEntity = Qualification.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification_id", insertable = false, updatable = false)
    private Qualification qualification;
}
