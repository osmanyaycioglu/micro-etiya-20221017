package org.training.ms.etiya.msorder.rest.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class  MealRest {
    @NotEmpty
    private String mealName;
    @Positive
    private Integer amount;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
