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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries")
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "name")
    private String name;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "iso")
    private String iso;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "phone_code")
    private String phoneCode;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "currency_code")
    private String currencyCode;

    // relations
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_user_id", insertable = false, updatable = false)
    private User createdUser;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "modified_user_id", insertable = false, updatable = false)
    private User modifiedUser;
}
