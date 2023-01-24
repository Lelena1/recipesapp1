package me.luppolem.recipesapp1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @NotBlank(message = "Введите название ингредиента!")
    private String nameOfIngredient;
    @Min(value = 0, message = "Количество ингредиента должно быть больше нуля!")
    private int countOfIngredient;
    @NotBlank(message = "Введите единицу измерения!")
    private String measureUnit;


}
