package com.kodlamaio.hrms.core.mailSender;

public interface MailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}
