package me.luppolem.recipesapp1.services;

import me.luppolem.recipesapp1.model.Recipe;

public interface RecipesService {

    void addRecipe(Recipe recipe);

    Recipe getRecipe(Long id);
}
