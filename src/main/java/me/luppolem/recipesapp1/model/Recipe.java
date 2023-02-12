package me.luppolem.recipesapp1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Recipe {
    @NotBlank(message = "Введите название рецепта!")
    private String nameOfRecipe;
    @Min(value = 0, message = "Время приготовления должно быть больше нуля!")
    private int cookingTimeMinutes;
    @NotBlank(message = "Напишите словами количество порций!")
    private String numberOfServings;
    private List<Ingredient> ingredients = new ArrayList<>();
    @NotBlank(message = "Введите шаги приготовления блюда по рецепту")
    private List<String> steps = new ArrayList<>();

    public Recipe(String nameOfRecipe, int cookingTimeMinutes, String numberOfServings, List<Ingredient> ingredients, List<String> steps) {
        this.nameOfRecipe = ValidateUtils.validateStringByDefault(nameOfRecipe);
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.numberOfServings = numberOfServings;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    @Override
    public String toString() {
        return nameOfRecipe + " " + cookingTimeMinutes + " " + numberOfServings + " " + ingredients + " " + steps;
    }
}
