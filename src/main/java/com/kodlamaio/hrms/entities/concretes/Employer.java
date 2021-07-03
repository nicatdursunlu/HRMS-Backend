package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "website")
    private String website;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "linkedin")
    private String linkedin;
}
