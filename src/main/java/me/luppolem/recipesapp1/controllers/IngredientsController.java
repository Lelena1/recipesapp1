package me.luppolem.recipesapp1.controllers;

import me.luppolem.recipesapp1.model.Ingredient;
import me.luppolem.recipesapp1.services.IngredientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/add")
    public String addIngredient(@RequestParam Ingredient ingredient) {
        ingredientsService.addIngredient(ingredient);
        return "Ингредиент успешно добавлен!" + ingredient;
    }

    @GetMapping("/get")
    public String getIngredient(@RequestParam Long id) {
        ingredientsService.getIngredient(id);
        return "Вы запросили ингредиент: " + id;
    }
}
