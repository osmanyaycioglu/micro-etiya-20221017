package org.training.ms.etiya.msorder.services.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@SequenceGenerator(name = "meal_sq",sequenceName = "meal_sq",initialValue = 1,allocationSize = 1)
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "meal_sq")
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
