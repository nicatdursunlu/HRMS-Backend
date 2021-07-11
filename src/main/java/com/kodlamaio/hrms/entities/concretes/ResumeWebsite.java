package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_websites")
@EqualsAndHashCode(callSuper = false)
public class ResumeWebsite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_website_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "resume_id")
    private int resumeId;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "website_type_id")
    private int webSiteTypeId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "website")
    private String website;

    // relations
    @JsonIgnore
    @ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @JsonIgnore
    @ManyToOne(targetEntity = WebsiteType.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "website_type_id", insertable = false, updatable = false)
    private WebsiteType websiteType;
}
