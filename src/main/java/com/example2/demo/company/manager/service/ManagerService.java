package com.example2.demo.company.manager.service;

import com.example2.demo.company.manager.repository.ManagerEntity;
import com.example2.demo.company.manager.repository.ManagerRepository;
import com.example2.demo.company.manager.rest.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;


    public Manager createManager(Manager manager) {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setFirstName(manager.getFistName());
        managerEntity.setLastname(manager.getLastName());

        ManagerEntity savedEntity = managerRepository.save(managerEntity);
        return convertManager(savedEntity);
    }

    public Manager getManager(Integer id) {
        Manager manager = new Manager();
        Optional<ManagerEntity> managerEntity = managerRepository.findById(id);
        if (managerEntity.isPresent()) {
            manager.setFistName(managerEntity.get().getFirstName());
            manager.setLastName(managerEntity.get().getLastname());
            return manager;
        }
        throw new RuntimeException("Invalid command");
    }


    public List<Manager> getAllManagers() {
        List<ManagerEntity> all = (List<ManagerEntity>) managerRepository.findAll();
        List<Manager> response = new ArrayList<>();

        for (ManagerEntity managerEntity : all) {
            Manager manager = convertManager(managerEntity);

            response.add(manager);
        }
        return response;
    }

    private static Manager convertManager(ManagerEntity managerEntity) {
        Manager manager = new Manager();
        manager.setFistName(managerEntity.getFirstName());
        manager.setLastName(managerEntity.getLastname());
        manager.setId(managerEntity.getId());
        return manager;
    }

    public void modifyManager(Integer id, Manager manager) {
        Optional<ManagerEntity> managerEntity = managerRepository.findById(id);
        if (managerEntity.isPresent()) {
            ManagerEntity newManagerEntity = managerEntity.get();

            newManagerEntity.setLastname(manager.getLastName());
            newManagerEntity.setFirstName(manager.getFistName());

            managerRepository.save(newManagerEntity);
        }
    }


    public void deleteById(Integer id) {
        managerRepository.deleteById(id);
    }

}
