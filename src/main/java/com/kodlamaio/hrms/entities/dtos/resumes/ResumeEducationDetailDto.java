package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEducationDetailDto {

    private int id;
    private String schoolName;
    private String departmentName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date startDate;

    private boolean isGraduate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date graduateDate;
}
