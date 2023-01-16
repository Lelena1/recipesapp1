package me.luppolem.recipesapp1.services.impl;

import me.luppolem.recipesapp1.model.Recipe;
import me.luppolem.recipesapp1.services.RecipesService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {
    private static long id = 0;
    private static Map<Long, Recipe> recipes = new HashMap<>();

    @Override
    public void addRecipe(Recipe recipe) {
        recipes.put(id++, recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipes.get(id);
    }
}
