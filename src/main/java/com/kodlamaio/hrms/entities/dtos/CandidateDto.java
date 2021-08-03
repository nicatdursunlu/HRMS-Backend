package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CandidateDto {

    private int id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String identityNumber;
//    private java.sql.Date birthDate;
    private String gender;

    private String linkedin;
    private String github;
    private String website;
    private String about;
    private String hobby;
}
