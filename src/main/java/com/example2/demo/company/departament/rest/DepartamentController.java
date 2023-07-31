package com.example2.demo.company.departament.rest;

import com.example2.demo.company.departament.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartamentController {
    @Autowired
    private DepartamentService departamentService;

    @PostMapping("/departament")
    public void setDepartament(@RequestBody Departament departament) {
        departamentService.createDepartment(departament);
    }

    @GetMapping("/departament/get")
    public Departament getDepartament(@RequestParam(value = "id") Integer id) {
        return departamentService.getDepartament(id);
    }

    @GetMapping("/departament/get/all")
    public List<Departament> getAllDepartaments() {
        return departamentService.getAllDepartaments();
    }

    @PutMapping("/departament/modify/{id}")
    public void modifyDepartamnet(@PathVariable Integer id, @RequestBody Departament departament) {
        departamentService.modifyDepartament(id, departament);
    }

    @DeleteMapping("/delete/departament/{id}")
    public void deleteById(@PathVariable Integer id){
        departamentService.deleteById(id);
    }

    @PutMapping("/manager-to-departament")
    public void managerToDepartament(@RequestParam(value = "id-manager") Integer idManager,
                                     @RequestParam(value = "id-departament") Integer idDepartament) {
        departamentService.managerToDepartament(idManager, idDepartament);
    }
}
