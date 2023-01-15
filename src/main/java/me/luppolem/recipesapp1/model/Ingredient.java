package me.luppolem.recipesapp1.model;
import java.util.Objects;

public class Ingredient {
    private String nameOfIngredient;
    private int countOfIngredients;
    private String measureUnit;

    public Ingredient(String nameOfIngredient, int countOfIngredients, String measureUnit) {
        this.nameOfIngredient = ValidateUtils.validateString(nameOfIngredient);
        this.countOfIngredients = ValidateUtils.validateInteger(countOfIngredients);
        this.measureUnit = ValidateUtils.validateString(measureUnit);
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = ValidateUtils.validateString(nameOfIngredient);
    }

    public int getCountOfIngredients() {
        return countOfIngredients;
    }

    public void setCountOfIngredients(int countOfIngredients) {
        this.countOfIngredients = ValidateUtils.validateInteger(countOfIngredients);
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = ValidateUtils.validateString(measureUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return countOfIngredients == that.countOfIngredients && Objects.equals(nameOfIngredient, that.nameOfIngredient) && Objects.equals(measureUnit, that.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfIngredient, countOfIngredients, measureUnit);
    }
}
