package com.kodlamaio.hrms.entities.dtos.resumes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeReferenceDetailDto {

    private int id;
    private String organization;
    private String position;
    private String firstName;
    private String lastName;
    private String description;

}
