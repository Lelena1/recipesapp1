package me.luppolem.recipesapp1.services.impl;

import me.luppolem.recipesapp1.model.Ingredient;
import me.luppolem.recipesapp1.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private static long id = 0;
    private final static Map<Long, Ingredient> ingredients = new HashMap<>();


    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        return id++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        for (Ingredient ingredient : ingredients.values()) {
            ingredient = ingredients.get(id);
            if (ingredient != null) {
                return ingredient;
            }
        }
        return null;

    }

    @Override
    public Collection<Ingredient> getAllIngredients(){
        return ingredients.values();
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
        for (Ingredient ingredient1 : ingredients.values()) {
            if (ingredients.containsKey(id)) {
                ingredients.put(id, ingredient1);
                return ingredient1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(long id) {
        for (Ingredient ingredient : ingredients.values()) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                return true;
            }
        }
        return false;
    }
}
