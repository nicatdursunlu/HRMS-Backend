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

    @JsonProperty("educations")
    public List<ResumeEducationDetailDto> resumeEducations;

    @JsonProperty("experiences")
    public List<ResumeExperienceDetailDto> resumeExperiences;

    @JsonProperty("skills")
    public List<ResumeSkillDetailDto> resumeSkills;

    @JsonProperty("projects")
    public List<ResumeProjectDetailDto> resumeProjects;

    @JsonProperty("languages")
    public List<ResumeLanguageDetailDto> resumeLanguages;

    @JsonProperty("certificates")
    public List<ResumeCertificateDetailDto> resumeCertificates;

    @JsonProperty("volunteers")
    public List<ResumeVolunteerDetailDto> resumeVolunteers;

    @JsonProperty("references")
    public List<ResumeReferenceDetailDto> resumeReferences;

    @JsonProperty("qualifications")
    public List<ResumeQualificationDetailDto> resumeQualifications;

}
