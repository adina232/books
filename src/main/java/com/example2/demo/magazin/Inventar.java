package com.example2.demo.magazin;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Inventar {
    List<Haina> inventar = new ArrayList<>();

    @PostMapping("/inventar/{haina}")
    public void addHaina(@RequestBody Haina haina) {
        inventar.add(haina);
    }

    @DeleteMapping("/inventar/sterge/{haina}")
    public void deleteHaina(@PathVariable String haina) {
        inventar.remove(getHaina(haina));
    }

    @GetMapping("/inventar/get-all")
    public List<Haina> getInventar() {
        return inventar;
    }

    @PutMapping("/inventar/modificare")
    public void modifica(@RequestParam(value = "denumire-haina") String numeHaina,
                         @RequestBody Haina haina) {
        Haina nou = getHaina(numeHaina);
        nou.setNumeHaina(haina.getNumeHaina());
        nou.setCantitate(haina.getCantitate());
        nou.setPurtat(haina.isPurtat());
    }

    private Haina getHaina(String hainaDeGasit) {
        for (int i = 0; i < inventar.size(); i++) {
            if (hainaDeGasit.equals(inventar.get(i).getNumeHaina())) {
                return inventar.get(i);
            }
        }
        throw new RuntimeException("Haina nu exista in inventar");
    }
}
