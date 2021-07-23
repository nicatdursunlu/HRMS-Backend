package com.kodlamaio.hrms.core.mailSender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderManager implements MailSenderService {

    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("nicat.dursunlu@gmail.com");
        simpleMailMessage.setFrom(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        System.out.println("Send Email");

        mailSender.send(simpleMailMessage);
    }
}
