package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeProjectDetailDto {

    private int id;
    private String title;
    private String description;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date endDate;

    private boolean isContinued;
}
