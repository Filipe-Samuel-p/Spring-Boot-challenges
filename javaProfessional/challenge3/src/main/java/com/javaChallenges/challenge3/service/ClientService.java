package com.javaChallenges.challenge3.service;


import com.javaChallenges.challenge3.dto.ClientDTO;
import com.javaChallenges.challenge3.model.Client;
import com.javaChallenges.challenge3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){

        Page<Client> allClients = repository.findAll(pageable);
        return allClients.map(client -> new ClientDTO(client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildrenQuantity()));

    }

}
