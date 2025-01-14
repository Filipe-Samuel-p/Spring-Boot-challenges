package com.javaChallenges.challenge3.dto;

import java.time.LocalDate;

public record ClientDTO(String name, String cpf,
                        Double income, LocalDate birthDate, Integer children_quantity) {


}
