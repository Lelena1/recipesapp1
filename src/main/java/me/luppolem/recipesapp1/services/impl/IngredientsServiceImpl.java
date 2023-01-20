package me.luppolem.recipesapp1.services.impl;

import me.luppolem.recipesapp1.model.Ingredient;
import me.luppolem.recipesapp1.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private static long id = 0;
    private static Map<Long, Ingredient> ingredients = new HashMap<>();


    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(Long id) {
        return ingredients.get(id);
    }
}
