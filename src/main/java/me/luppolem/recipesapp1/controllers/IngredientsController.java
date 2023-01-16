package me.luppolem.recipesapp1.controllers;

import me.luppolem.recipesapp1.model.Ingredient;
import me.luppolem.recipesapp1.services.IngredientsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    public String addIngredient(@RequestBody Ingredient ingredient) {
        ingredientsService.addIngredient(ingredient);
        return "Ингредиент успешно добавлен!" + ingredient;
    }

    @GetMapping("/get")
    public Ingredient getIngredient(@RequestParam Long id) {
        return ingredientsService.getIngredient(id);
    }
}

