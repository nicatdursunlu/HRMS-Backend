package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "states")
@EqualsAndHashCode(callSuper = false)
public class State extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int id;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "country_id")
    private int countryId;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "name")
    private String name;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "code")
    private String code;

}
