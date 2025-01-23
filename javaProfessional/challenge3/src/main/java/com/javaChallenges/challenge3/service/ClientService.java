package com.javaChallenges.challenge3.service;


import com.javaChallenges.challenge3.dto.ClientDTO;
import com.javaChallenges.challenge3.exceptions.ResourceNotFoundException;
import com.javaChallenges.challenge3.model.Client;
import com.javaChallenges.challenge3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){

        Page<Client> allClients = repository.findAll(pageable);
        return allClients.map(ClientDTO::new);

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){

        Client clientDataBase = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + id + " nåo encontrado"));
        return new ClientDTO(clientDataBase);
    }

    @Transactional
    public ClientDTO insertClient(ClientDTO user){

        Client entity = new Client();
        dtoToEntity(user,entity);
        entity = repository.save(entity); // Aqui há a persistencia de dados. O método "save" retorna a própria entidade com os dados salvos, como ID inserido automaticamente etc
        return new ClientDTO(entity);

    }

    private void dtoToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildrenQuantity(dto.getChildrenQuantity());
        entity.setIncome(dto.getIncome());
    }

}
