package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@EqualsAndHashCode(callSuper = false)
public class Language extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "name", unique = true)
    private String name;

    // relations
//    @JsonIgnore
//    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
//    private User createdUser;
//
//    @JsonIgnore
//    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
//    private User modifiedUser;
}
