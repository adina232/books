package com.example2.demo.tourismAgency.client.service;

import com.example2.demo.tourismAgency.client.repository.ClientEntity;
import com.example2.demo.tourismAgency.client.repository.ClientRepository;
import com.example2.demo.tourismAgency.client.rest.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        setClientEntity(client, clientEntity);

        clientRepository.save(clientEntity);
    }

    public List<Client> getClients() {
        Iterable<ClientEntity> clientEntities = clientRepository.findAll();
        List<Client> clients = new ArrayList<>();
        for (ClientEntity clientEntity : clientEntities) {
            Client client = new Client();
            setClient(client, clientEntity);

            clients.add(client);
        }

        return clients;
    }

    public Client getClient(Integer id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        Client client = new Client();
        if(clientEntity.isPresent()) {
            setClient(client, clientEntity.get());
        } else throw new RuntimeException("Client not on the list");

        return client;
    }

    public void modifyClient(Integer id, Client client) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        if(clientEntity.isPresent()) {
            setClientEntity(client, clientEntity.get());

            clientRepository.save(clientEntity.get());
        } else throw new RuntimeException("Client not on the list");
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }




    private void setClient(Client client, ClientEntity clientEntity) {
        client.setName(clientEntity.getName());
        client.setBudget(clientEntity.getBudget());
    }

    private void setClientEntity(Client client, ClientEntity clientEntity) {
        clientEntity.setName(client.getName());
        clientEntity.setBudget(client.getBudget());
    }
}
