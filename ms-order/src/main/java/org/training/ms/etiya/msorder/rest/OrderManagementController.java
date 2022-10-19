package org.training.ms.etiya.msorder.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.ms.etiya.msorder.rest.models.MealRest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @GetMapping("/add/meal/to/order")
    public String addOrder(@RequestParam("mealName") String mealName,
                           @RequestParam("amount") Integer amount) {
        return "OK";
    }

    @PostMapping("/add/meals/to/order")
    public String addOrder(List<MealRest> mealRests) {
        return "OK";
    }


}
