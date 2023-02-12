package me.luppolem.recipesapp1.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.luppolem.recipesapp1.model.Recipe;
import me.luppolem.recipesapp1.services.FilesService;
import me.luppolem.recipesapp1.services.RecipesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {
    @Value("${name.of.recipes.data.file}")
    private String dataFileName;


    final private FilesService filesService;
    private static long id = 0L;
    private static Map<Long, Recipe> recipes = new HashMap<>();

    public RecipesServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(id, recipe);
        saveToFile();
        return id++;
    }

    @Override
    public Recipe getRecipe(long id) {
        for (Recipe recipe : recipes.values()) {
            recipe = recipes.get(id);
            if (recipe != null) {
                return recipe;
            }
        }
        return null;
    }


    @Override
    public Collection<Recipe> getAllRecipes() {
        return recipes.values();
    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        for (Recipe recipe1 : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.put(id, recipe1);
                saveToFile();
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

    @Override
    public Path createRecipesFile() throws IOException {
        recipes.getOrDefault(id, null);
        Path path = filesService.createTempFile("recipesFile");
        for (Recipe recipe : recipes.values()) {
            try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                writer.append(recipe.getNameOfRecipe() + ": " + recipe.getCookingTimeMinutes() + " мин. "
                        + recipe.getNumberOfServings() + " " + recipe.getIngredients() + " " + recipe.getSteps());
                writer.append("\n");
            }
        }
        return path;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToFile(json, dataFileName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile(dataFileName);
            recipes = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
