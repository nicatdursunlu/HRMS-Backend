package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "identity_number")
    private String identityNumber;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "birth_date")
    private java.sql.Date birthDate;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "gender")
    private String gender;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "github")
    private String github;

    @Column(name = "website")
    private String website;

    @Column(name = "about")
    private String about;

    @Column(name = "hobby")
    private String hobby;

}
