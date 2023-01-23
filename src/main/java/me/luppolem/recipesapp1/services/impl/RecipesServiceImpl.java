package me.luppolem.recipesapp1.services.impl;

import me.luppolem.recipesapp1.model.Recipe;
import me.luppolem.recipesapp1.services.RecipesService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {
    private static long id = 0;
    private static final Map<Long, Recipe> recipes = new HashMap<>();

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(id, recipe);
        return id++;
    }

    @Override
    public Recipe getRecipe(long id) {
        for (Recipe recipe : recipes.values()){
           recipe = recipes.get(id);
            if (recipe  != null) {
                return recipe;
            }
        }
        return null;
    }


    @Override
    public Collection<Recipe> getAllRecipes(){
        return recipes.values();
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        for (Recipe recipe1 : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.put(id, recipe1);
                return recipe1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(long id) {
        for (Recipe recipe : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.remove(id);
                return true;
            }
        }
        return false;
    }
}
