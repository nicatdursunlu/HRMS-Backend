package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_verifications")
public class UserVerification {

    @Id
    @Column(name = "user_verification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "user_id")
    private int userId;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Column(name = "code")
    private String code;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "expiry_date")
    private Instant expiryDate;

    @NotNull(message = ValidationMessages.NOT_BLANK)
    @Column(name = "verification_date")
    private Instant verificationDate;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
