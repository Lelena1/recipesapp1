package me.luppolem.recipesapp1.services;

import me.luppolem.recipesapp1.model.Ingredient;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;


public interface IngredientsService {
    long addIngredient(Ingredient ingredient);

    Ingredient getIngredient(long id);

    Collection<Ingredient> getAllIngredients();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);

    Path createIngredientsFile() throws IOException;
}
