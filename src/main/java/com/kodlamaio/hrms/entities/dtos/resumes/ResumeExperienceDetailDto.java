package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeExperienceDetailDto {

    private int id;
    private String companyName;
    private int jobTitleId;
    private String jobTitle;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;
    private boolean isContinued;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;
}
