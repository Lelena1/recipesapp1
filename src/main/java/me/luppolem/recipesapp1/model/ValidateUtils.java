package me.luppolem.recipesapp1.model;

public class ValidateUtils {
    public static String validateString(String value) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException("Заполнено не корректно!");
        }
        return value;
    }

    public static int validateInteger(int value) {

        if (value <= 0) {
            throw new IllegalArgumentException("Заполнено не корректно!");
        }
        return value;
    }
}
