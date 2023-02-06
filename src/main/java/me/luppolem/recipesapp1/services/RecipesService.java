package me.luppolem.recipesapp1.services;

import me.luppolem.recipesapp1.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface RecipesService {

    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Collection<Recipe> getAllRecipes();

    Recipe editRecipe(long id, Recipe recipe);

    boolean deleteRecipe(long id);


    Path createRecipesFile() throws IOException;
}


