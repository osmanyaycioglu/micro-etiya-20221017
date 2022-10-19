package org.training.ms.etiya.msorder.services.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Meal {
    private Long mealId;
    private String mealName;
    private Integer amount;

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

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
