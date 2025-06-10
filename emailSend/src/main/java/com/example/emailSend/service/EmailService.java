package com.example.emailSend.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("youssefalm8877@gmail.com");
        message.setTo("Mohammed.hussein.phonetics@gmail.com");
        mailSender.send(message);
    }

    public void sendEmailWithImageAttachment() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true for multipart

            helper.setTo("Mohammed.hussein.phonetics@gmail.com");
            helper.setSubject("Hello with Image");
            helper.setText("Hi Mohammed,\nPlease find the attached image.\nRegards,\nYoussef");
            helper.setFrom("youssefalm8877@gmail.com");

            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\youss\\OneDrive\\Desktop\\design .jpg"));
            helper.addAttachment("image.jpg", file);

            mailSender.send(message);
            System.out.println("Email sent with image successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailWithPdfAttachment() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true = multipart

            helper.setTo("Mohammed.hussein.phonetics@gmail.com");
            helper.setSubject("Hello with PDF");
            helper.setText("Hi Mohammed,\nPlease find the attached PDF file.\nRegards,\nYoussef");
            helper.setFrom("youssefalm8877@gmail.com");

            File pdfFile = new File("E:\\web\\Docker.pdf");
            if (!pdfFile.exists()) {
                System.out.println("PDF file not found: " + pdfFile.getAbsolutePath());
                return;
            }

            FileSystemResource pdfResource = new FileSystemResource(pdfFile);
            helper.addAttachment("Docker.pdf", pdfResource);

            mailSender.send(message);
            System.out.println("Email sent with PDF successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}