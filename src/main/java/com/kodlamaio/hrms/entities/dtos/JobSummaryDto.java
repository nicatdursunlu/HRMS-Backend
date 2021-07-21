package com.kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSummaryDto {
    private int id;
    private String companyName;
    private String jobTitle;
    private BigDecimal applicantQuota;
    private Instant createdDate;
    private Date lastApplicationDate;

//    private String state;
//    private String title;
//    private String description;
//    private BigDecimal maxSalary;
//    private BigDecimal minSalary;
}
