package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeSummaryDto {

    private int resumeId;

    @JsonProperty("firstName")
    private String createdUserFirstName;

    @JsonProperty("lastName")
    private String createdUserLastName;

    @JsonProperty("email")
    private String createdUserEmail;

    @JsonProperty("birthDate")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date createdUserBirthDate;

    private String profilePictureUrl;
    private String coverLetter;
}
