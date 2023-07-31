package com.example2.demo.tourismAgency.client.rest;

import com.example2.demo.tourismAgency.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

//    @Autowired
    private ClientService clientService;

    @PutMapping("/client")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/client")
    public Client getClient(@RequestParam(value = "id") Integer id) {
        return clientService.getClient(id);
    }

    @PutMapping("/client/modify/{id}")
    public void modifyClient(@PathVariable Integer id, @RequestBody Client client) {
        clientService.modifyClient(id, client);
    }

    @DeleteMapping("/delete/client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
