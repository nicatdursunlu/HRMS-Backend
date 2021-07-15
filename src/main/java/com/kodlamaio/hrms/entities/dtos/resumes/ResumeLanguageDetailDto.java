package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeLanguageDetailDto {

    private int id;

    @JsonProperty("languageId")
    private int languageId;

    private Instant createdDate;
    private String languageName;
    private BigDecimal grade;
}
