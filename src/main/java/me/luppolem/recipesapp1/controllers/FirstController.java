package me.luppolem.recipesapp1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String applicationLaunched(){
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String printInfo(@RequestParam String info){
        return "Info: Проект #RecipesApp1 создан 1 января 2023 года Луппол Еленой и содержит сборник различных рецептов" + info;
    }

}
