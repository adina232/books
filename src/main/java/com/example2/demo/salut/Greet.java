package com.example2.demo.salut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {

    private String mesaj = "Buna, %s";

    private static int numara = 0;
    private String mesaje = "Buna ziua, %s!";
    @GetMapping("/")
    public String greet() {
        return "Hello, darling!";
    }
    @GetMapping("/greeting")
    public String greetMe(){
        return "Hello, [name]";
    }
    @GetMapping("/greetings")
    public ID greetName(@RequestParam (value = "id", defaultValue = "Attila") String id) {
        return new ID(String.format(mesaj, id));
    }
    @GetMapping("/saluta")
    public Saluta saluta (@RequestParam (value = "nume", defaultValue = "domnule") String nume){
        numara++;
        return new Saluta(numara, String.format(mesaje, nume));
    }

}
