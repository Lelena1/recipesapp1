package me.luppolem.recipesapp1.services;

import me.luppolem.recipesapp1.model.Ingredient;


public interface IngredientsService {
    void addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Long id);
}
