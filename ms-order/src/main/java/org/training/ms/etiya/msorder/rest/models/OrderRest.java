package org.training.ms.etiya.msorder.rest.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderRest {

    @NotEmpty
    @Size(max = 30)
    private String customer;
    @Size(min = 8,max = 30)
    private String customerNumber;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<MealRest> meals;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<MealRest> getMeals() {
        return meals;
    }

    public void setMeals(List<MealRest> meals) {
        this.meals = meals;
    }
}
