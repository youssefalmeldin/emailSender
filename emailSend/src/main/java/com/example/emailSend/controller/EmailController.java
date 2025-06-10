package com.example.emailSend.controller;

import com.example.emailSend.model.EmailRequest;
import com.example.emailSend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        emailService.sendSimpleEmail(request.getTo(), request.getSubject(), request.getBody());
        return "✅ Email sent successfully to " + request.getTo();
    }

    @PostMapping("/send-with-image")
    public String sendEmailWithImage() {
        emailService.sendEmailWithImageAttachment();
        return "Email with image sent successfully!";
    }

    @PostMapping("/send-pdf")
    public String sendEmailWithPdf(@RequestBody EmailRequest request) {
        emailService.sendEmailWithPdfAttachment();
        return "Email with PDF sent successfully!";
    }
}