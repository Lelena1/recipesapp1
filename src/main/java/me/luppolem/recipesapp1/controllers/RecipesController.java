package me.luppolem.recipesapp1.controllers;

import me.luppolem.recipesapp1.model.Recipe;
import me.luppolem.recipesapp1.services.RecipesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
    private RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/add")
    public String addRecipe(@RequestBody Recipe recipe) {
        recipesService.addRecipe(recipe);
        return "Рецепт успешно добавлен!" + recipe;
    }

    @GetMapping("/get")
    public Recipe getRecipe(@RequestParam Long id) {
        return recipesService.getRecipe(id);
    }
}
