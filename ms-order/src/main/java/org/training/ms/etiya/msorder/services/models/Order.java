package org.training.ms.etiya.msorder.services.models;


import org.training.ms.etiya.msorder.rest.models.MealRest;
import org.training.ms.etiya.msorder.validation.ContainsString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@SequenceGenerator(name = "order_sq",sequenceName = "order_sq",initialValue = 1,allocationSize = 1)
@Table(name = "restaurant_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_sq")
    private Long       orderId;
    private String     customerName;
    private String     customerNumber;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Meal> meals;
    @Enumerated(EnumType.STRING)
    private EOrderState orderState =EOrderState.ACTIVE;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public EOrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(EOrderState orderState) {
        this.orderState = orderState;
    }
}
