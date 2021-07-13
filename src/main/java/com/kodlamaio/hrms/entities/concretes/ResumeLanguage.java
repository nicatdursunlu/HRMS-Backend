package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_languages")
@EqualsAndHashCode(callSuper = false)
public class ResumeLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_language_id")
    private int id;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "language_id")
    private int languageId;

//    @Size(min = 1, max = 5, message = ValidationMessages.GRADE_MUST_BE_BETWEEN)
    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "grade")
    private int grade;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @JsonIgnore
    @ManyToOne(targetEntity = Language.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;
}
