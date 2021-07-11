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
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User {

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
}
