package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createDate = Instant.now();

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted = false;

    @JsonIgnore
    @Column(name = "is_active")
    private boolean active = false;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Length(max = 320, message = ValidationMessages.EMAIL_MAX_LENGTH)
    @Email(message = ValidationMessages.EMAIL_VERIFICATION)
    @Column(name = "email", unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Length(max = 25, message = ValidationMessages.PASSWORD_MAX_LENGTH)
    @Column(name = "password")
    private String password;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Length(max = 25)
    @Column(name = "phone")
    private String phone;
}
