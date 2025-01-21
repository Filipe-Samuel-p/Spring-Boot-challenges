package com.javaChallenges.challenge3.service;


import com.javaChallenges.challenge3.dto.ClientDTO;
import com.javaChallenges.challenge3.exceptions.ResourceNotFoundException;
import com.javaChallenges.challenge3.model.Client;
import com.javaChallenges.challenge3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){

        Page<Client> allClients = repository.findAll(pageable);
        return allClients.map(client -> new ClientDTO(client.getName(), client.getCpf(), client.getIncome(), client.getBirthDate(), client.getChildrenQuantity()));

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){

        Client clientDataBase = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + id + " nåo encontrado"));
        return new ClientDTO(clientDataBase.getName(), clientDataBase.getCpf(), clientDataBase.getIncome(),
                clientDataBase.getBirthDate(), clientDataBase.getChildrenQuantity());

    }

    public ClientDTO includeClient(ClientDTO user){

        Client entity = new Client();
        dtoToEntity(user,entity);
        entity = repository.save(entity); // Aqui há a persistencia de dados. O método "save" retorna a própria entidade com os dados salvos, como ID inserido automaticamente etc
        return new ClientDTO(entity.getName(),entity.getCpf(),entity.getIncome(),
                entity.getBirthDate(),entity.getChildrenQuantity());

    }


    private void dtoToEntity(ClientDTO dto, Client entity){

        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setBirthDate(dto.birthDate());
        entity.setChildrenQuantity(dto.children_quantity());
        entity.setIncome(dto.income());

    }

}
