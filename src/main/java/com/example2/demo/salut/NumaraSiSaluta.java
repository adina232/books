package com.example2.demo.salut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumaraSiSaluta {
    private static int numaram = 0;
    private String mesajele = "Buna ziua, %s!";

    @GetMapping("/salutam")
    public Saluta saluta (@RequestParam(value = "numele", defaultValue = "World") String nume){
        numaram++;
        return new Saluta(numaram, String.format(mesajele, nume));
    }
}
