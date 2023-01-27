package me.luppolem.recipesapp1.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class ValidateUtils {
    public static String validateStringByDefault(String value) {
        return StringUtils.defaultString(null, "Введите данные!");
    }
}
