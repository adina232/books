package com.example2.demo.company.manager.rest;

import com.example2.demo.company.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/manager/set")
    public void setDepartament(@RequestBody Manager manager) {
        managerService.createManager(manager);
    }

    @GetMapping("/manager/get")
    public Manager getManager(@RequestParam(value = "id") Integer id) {
        return managerService.getManager(id);
    }

    @GetMapping("/manager/get/all")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @PutMapping("/manager/modify/{id}")
    public void modifyManager(@PathVariable Integer id, @RequestBody Manager manager) {
        managerService.modifyManager(id, manager);
    }

    @DeleteMapping("/delete/manager/{id}")
    public void deleteById(@PathVariable Integer id) {
        managerService.deleteById(id);
    }
}
