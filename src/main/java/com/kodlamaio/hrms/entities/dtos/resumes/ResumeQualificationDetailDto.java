package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeQualificationDetailDto {

    private int id;

    @JsonProperty("qualificationId")
    private int qualificationId;

    private String qualification;
    private BigDecimal grade;
}
