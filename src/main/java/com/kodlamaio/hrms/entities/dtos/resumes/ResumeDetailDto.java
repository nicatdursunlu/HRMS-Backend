package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResumeDetailDto extends ResumeSummaryDto {

    @JsonProperty("qualifications")
    public List<ResumeQualificationDetailDto> resumeQualifications;

    @JsonProperty("websites")
    public List<ResumeWebsiteDetailDto> resumeWebsites;

    @JsonProperty("languages")
    public List<ResumeLanguageDetailDto> resumeLanguages;

    @JsonProperty("educations")
    public List<ResumeEducationDetailDto> resumeEducations;

    @JsonProperty("experiences")
    public List<ResumeExperienceDetailDto> resumeExperiences;
}
