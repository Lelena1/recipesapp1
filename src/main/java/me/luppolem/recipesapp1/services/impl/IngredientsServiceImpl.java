package me.luppolem.recipesapp1.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.luppolem.recipesapp1.model.Ingredient;
import me.luppolem.recipesapp1.services.FilesService;
import me.luppolem.recipesapp1.services.IngredientsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    @Value("${name.of.ingredients.data.file}")
    private String dataFileName;
    final private FilesService filesService;
    private static long id = 0L;
    private static Map<Long, Ingredient> ingredients = new HashMap<>();

    public IngredientsServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        saveToFile();
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
                saveToFile();
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
    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToFile(json,dataFileName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile(dataFileName);
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
