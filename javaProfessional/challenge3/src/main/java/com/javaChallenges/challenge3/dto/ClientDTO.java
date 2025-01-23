package com.javaChallenges.challenge3.dto;

import com.javaChallenges.challenge3.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClientDTO {

    private long id;
    private String name;
    private String cpf;
    private Double income; //(Renda)
    private LocalDate birthDate;
    private Integer childrenQuantity;

    public ClientDTO(Client client){

        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.birthDate = client.getBirthDate();
        this.income = client.getIncome();
        this.childrenQuantity = client.getChildrenQuantity();

    }


}
