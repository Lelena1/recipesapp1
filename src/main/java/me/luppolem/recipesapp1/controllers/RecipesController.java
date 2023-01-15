package me.luppolem.recipesapp1.controllers;

import me.luppolem.recipesapp1.model.Recipe;
import me.luppolem.recipesapp1.services.RecipesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
    private RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping("/add")
    public String addRecipe(@RequestParam Recipe recipe) {
        recipesService.addRecipe(recipe);
        return "Рецепт успешно добавлен!" + recipe;
    }

    @GetMapping("/get")
    public String getRecipe(@RequestParam Long id) {
        recipesService.getRecipe(id);
        return "Вы запросили рецепт: " + id;
    }
}
