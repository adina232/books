package com.example2.demo.cumparaturi.rest;

import com.example2.demo.cumparaturi.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    List<Produs> listaCumparaturi = new ArrayList<>();

    @PostMapping("/cumparaturi")
    public void addProdus(@RequestBody Produs produs) {
        produsService.addProdus(produs);
    }

    @GetMapping("/lista-cumparaturi-full")
    public List<Produs> seeFullList() {
        return produsService.getCumparaturi();
    }

    @GetMapping("/produs/{produs}")
    public Produs produs(@PathVariable String produs) {
        return produsService.getProdus(produs);
    }

    @PutMapping("/cumpara")
    public void modificaProdus(@RequestParam(value = "nume-produs") String numeProdus, @RequestBody
    Produs produs) {
        produsService.modifyProdus(numeProdus, produs);
    }

    @DeleteMapping("/produs/{produs}")
    public void stergeProdus(@PathVariable String produs) {
        produsService.deleteProdus(produs);
    }
}
