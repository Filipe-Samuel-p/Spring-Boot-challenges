package com.filipePires.API_EmailSender.service;


import com.filipePires.API_EmailSender.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private final JavaMailSender sender;

    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail (EmailDTO dto){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(message.getFrom());
        message.setTo(dto.getToWho());
        message.setSubject(dto.getTitle());
        message.setText(dto.getMessage());

        sender.send(message);

    }
}

