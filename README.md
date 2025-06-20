# emailSender

# 📧 Spring Boot Email Sender

This project demonstrates how to send emails using **Spring Boot** and **Gmail SMTP**.  
It supports sending:

- ✅ Simple text emails  
- 🖼️ Emails with image attachments  
- 📄 Emails with PDF attachments  

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Mail (`JavaMailSender`)
- Gmail SMTP

---

## 📁 Project Structure

src/main/java/com/example/emailSend/
├── controller/
│ └── EmailController.java # REST controller with endpoints
├── service/
│ └── EmailService.java # Logic for sending different types of emails
├── model/
│ └── EmailRequest.java # DTO for email request
└── EmailSendApplication.java # Spring Boot main class



---

## ⚙️ Configuration

In `src/main/resources/application.properties`, set your Gmail SMTP credentials:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youssefalm8877@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Build and run the project
./mvnw spring-boot:run

