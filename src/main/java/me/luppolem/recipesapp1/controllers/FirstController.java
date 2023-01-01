package me.luppolem.recipesapp1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String applicationLaunched(){
        return "Приложение запущено";
    }


}
