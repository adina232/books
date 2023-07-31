package com.example2.demo.saluturi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Salut {
    private String salut = "Salut, %s!";

    @GetMapping("/sal")
    public String sal() {
        return "Salut, lume!";
    }

    @GetMapping("/salut/{prenume}")
    public String saluta(@PathVariable String prenume) {
        return String.format(salut,prenume);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "prenume", defaultValue = "people") String prenume) {
        return String.format(salut, prenume);
    }
}
