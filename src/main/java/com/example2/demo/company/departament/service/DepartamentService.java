package com.example2.demo.company.departament.service;

import com.example2.demo.company.departament.repository.DepartamentEntity;
import com.example2.demo.company.departament.repository.DepartamentRepository;
import com.example2.demo.company.departament.rest.Departament;
import com.example2.demo.company.manager.repository.ManagerEntity;
import com.example2.demo.company.manager.repository.ManagerRepository;
import com.example2.demo.company.manager.rest.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentService {
    @Autowired
    private DepartamentRepository departamentRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public void createDepartment(Departament departament) {
//        Manager manager = departament.getManager();
//        ManagerEntity managerEntity = new ManagerEntity();
//        managerEntity.setFirstName(manager.getFistName());
//        managerEntity.setLastname(manager.getLastName());
//
//        ManagerEntity savedManager = managerRepository.save(managerEntity);


        DepartamentEntity departamentEntity = new DepartamentEntity();
        departamentEntity.setLabel(departament.getLabel());
        departamentEntity.setPeople(departament.getPeople());
//        departamentEntity.setManager(savedManager);


        departamentRepository.save(departamentEntity);
    }


    public Departament getDepartament(Integer id) {
        Departament departament = new Departament();
        Manager manager = new Manager();
        Optional<DepartamentEntity> departamentEntity = departamentRepository.findById(id);
        if (departamentEntity.isPresent()) {
            departament.setLabel(departamentEntity.get().getLabel());
            departament.setPeople(departamentEntity.get().getPeople());

            manager.setId(departamentEntity.get().getManagerEntity().getId());
            manager.setFistName(departamentEntity.get().getManagerEntity().getFirstName());
            manager.setLastName(departamentEntity.get().getManagerEntity().getLastname());

            departament.setManager(manager);
            return departament;
        }
        throw new RuntimeException("Invalid command");
    }


    public List<Departament> getAllDepartaments() {
        List<DepartamentEntity> all = (List<DepartamentEntity>) departamentRepository.findAll();
        List<Departament> response = new ArrayList<>();

        Manager manager = new Manager();

        for (DepartamentEntity departamentEntity : all) {
            Departament departament = new Departament();
            departament.setPeople(departamentEntity.getPeople());
            departament.setLabel(departamentEntity.getLabel());

            manager.setId(departamentEntity.getManagerEntity().getId());
            manager.setLastName(departamentEntity.getManagerEntity().getLastname());
            manager.setFistName(departamentEntity.getManagerEntity().getFirstName());

            departament.setManager(manager);

            response.add(departament);
        }
        return response;
    }

    public void modifyDepartament(Integer id, Departament departament) {
        Optional<DepartamentEntity> departamentEntity = departamentRepository.findById(id);
        if (departamentEntity.isPresent()) {
            DepartamentEntity newDepartamentEntity = departamentEntity.get();

            newDepartamentEntity.setPeople(departament.getPeople());
            newDepartamentEntity.setLabel(departament.getLabel());

            ManagerEntity managerEntity = newDepartamentEntity.getManagerEntity();

            managerEntity.setLastname(departament.getManager().getLastName());
            managerEntity.setFirstName(departament.getManager().getFistName());

            managerRepository.save(managerEntity);
            departamentRepository.save(newDepartamentEntity);
        }
    }

    public void deleteById(Integer id) {
        Optional<DepartamentEntity> departament = departamentRepository.findById(id);
        if (departament.isPresent()) {
            departamentRepository.deleteById(id);
            managerRepository.deleteById(departament.get().getManagerEntity().getId());
        }
    }

    public void managerToDepartament(Integer idManager, Integer idDepartament) {
        Optional<ManagerEntity> managerEntity = managerRepository.findById(idManager);
        if (managerEntity.isPresent()) {
            Optional<DepartamentEntity> departamentEntity =
                    departamentRepository.findById(idDepartament);
            if (departamentEntity.isPresent()) {
                departamentEntity.get().setManager(managerEntity.get());
//                managerEntity.get().getDepartments().add(departamentEntity.get());
                departamentRepository.save(departamentEntity.get());

            } else throw new RuntimeException("Departament not on the list");
        } else throw new RuntimeException("Manager not on the list");
    }
}
