package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCertificateDetailDto {

    private int id;
    private String title;
    private String description;
    private String organization;
    private String degree;
    private String certificateNumber;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date givenDate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;

    private boolean isLimitless;
}
