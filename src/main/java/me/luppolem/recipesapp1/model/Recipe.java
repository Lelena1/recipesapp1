package me.luppolem.recipesapp1.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String nameOfRecipe;
    private int cookingTimeMinutes;
    private int numberOfServings;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> steps = new ArrayList<>();

    public Recipe(String nameOfRecipe, int cookingTimeMinutes, int numberOfServings, List<Ingredient> ingredients, List<String> steps) {
        this.nameOfRecipe = ValidateUtils.validateString(nameOfRecipe);
        this.cookingTimeMinutes = ValidateUtils.validateInteger(cookingTimeMinutes);
        this.numberOfServings = ValidateUtils.validateInteger(numberOfServings);
        this.ingredients = ingredients;
        this.steps = steps;

    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = ValidateUtils.validateInteger(numberOfServings);
    }

    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public void setNameOfRecipe(String nameOfRecipe) {
        this.nameOfRecipe = ValidateUtils.validateString(nameOfRecipe);
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        this.cookingTimeMinutes = ValidateUtils.validateInteger(cookingTimeMinutes);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTimeMinutes == recipe.cookingTimeMinutes && numberOfServings == recipe.numberOfServings && Objects.equals(nameOfRecipe, recipe.nameOfRecipe) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfRecipe, cookingTimeMinutes, numberOfServings, ingredients, steps);
    }
}
