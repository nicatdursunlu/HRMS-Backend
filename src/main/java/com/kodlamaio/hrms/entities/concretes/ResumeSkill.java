package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_skills")
public class ResumeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_skill_id")
    private int id;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @Column(name = "level")
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String level;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "skill_id")
    private int skillId;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @JsonIgnore
    @ManyToOne(targetEntity = Skill.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;
}