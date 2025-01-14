package com.javaChallenges.challenge3.service;


import com.javaChallenges.challenge3.model.Client;
import com.javaChallenges.challenge3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        List<Client> obj = repository.findAll();
        return obj;
    }

}
