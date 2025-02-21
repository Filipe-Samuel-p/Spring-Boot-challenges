package com.filipePires.API_EmailSender.controllers;


import com.filipePires.API_EmailSender.dto.EmailDTO;
import com.filipePires.API_EmailSender.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
@RequiredArgsConstructor
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping(value = "/send")
    public ResponseEntity<EmailDTO> sendEmail(@RequestBody EmailDTO dto){
        service.sendEmail(dto);
        return ResponseEntity.ok(dto);

    }

}
