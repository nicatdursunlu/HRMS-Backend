package com.kodlamaio.hrms.core.utilities.verification;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationManager implements VerificationService {

    @Override
    public void sendLink(String email) {
        UUID uuid = UUID.randomUUID();
        String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
        System.out.println("Verification ink sent to mail " + email);
        System.out.println("Please, click on the link to verify your account " + verificationLink);
    }

    @Override
    public String sendCode() {
        UUID uuid = UUID.randomUUID();
        String verificationCode = uuid.toString();
        System.out.println("Your activation code:  " + verificationCode);
        return verificationCode;
    }
}
