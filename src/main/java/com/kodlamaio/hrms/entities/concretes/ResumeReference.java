package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_references")
public class ResumeReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_reference_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "firstname")
    private String firstName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "lastname")
    private String lastName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "organization")
    private String organization;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private String position;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Length(max = 320, message = ValidationMessages.EMAIL_MAX_LENGTH)
    @Email(message = ValidationMessages.EMAIL_VERIFICATION)
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Length(max = 25)
    @Column(name = "phone")
    private String phone;

    // relation mapping.
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;
}
