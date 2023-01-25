package me.luppolem.recipesapp1.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import static org.apache.el.parser.ELParserConstants.COMMA;


@Data
@NoArgsConstructor
public class Ingredient {
    @NotBlank(message = "Введите название ингредиента!")
    private String nameOfIngredient;
    @Min(value = 0, message = "Количество ингредиента должно быть больше нуля!")
    private int countOfIngredient;
    @NotBlank(message = "Введите единицу измерения!")
    private String measureUnit;

    public Ingredient(String nameOfIngredient, int countOfIngredient, String measureUnit) {
        this.nameOfIngredient = ValidateUtils.validateStringByDefault(nameOfIngredient);
        this.countOfIngredient = countOfIngredient;
        this.measureUnit = ValidateUtils.validateStringByDefault(measureUnit);
    }
}
