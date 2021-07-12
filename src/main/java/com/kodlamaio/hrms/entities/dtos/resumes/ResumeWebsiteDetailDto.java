package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWebsiteDetailDto {

    private int id;

    @JsonProperty("websiteTypeId")
    private int websiteTypeId;

    private String websiteName;
    private String website;
}
