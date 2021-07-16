package com.kodlamaio.hrms.entities.dtos.resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeSkillDetailDto {

    private int id;

    @JsonProperty("skillId")
    private int skillId;

    private Instant createdDate;
    private String name;
    private String level;
}
