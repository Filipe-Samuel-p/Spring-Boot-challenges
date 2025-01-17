package com.javaChallenges.challenge3.dto;

import java.time.Instant;

public record CustomErrorDTO (Instant timestamp,
         Integer status, String error, String path){


}

