package com.javaChallenges.challenge3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CustomErrorDTO{

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;



}




