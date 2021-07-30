package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes")
@EqualsAndHashCode(callSuper = false)
public class Resume extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private int id;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "cover_letter")
    private String coverLetter;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeQualification> resumeQualifications;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeWebsite> resumeWebsites;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeLanguage> resumeLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeEducation> resumeEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeExperience> resumeExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeSkill> resumeSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<ResumeProject> resumeProjects;

    // relations
    @ManyToOne(targetEntity = Candidate.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private Candidate createdUser;

    @ManyToOne(targetEntity = Candidate.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private Candidate modifiedUser;
}
