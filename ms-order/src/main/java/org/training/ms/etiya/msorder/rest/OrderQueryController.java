package org.training.ms.etiya.msorder.rest;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryController {

    @GetMapping("/get/one/{oid}")
    public Order getOrder(@PathVariable("oid") Long orderId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Order> getAll() {
        return null;
    }

    @GetMapping("/get/actives")
    public List<Order> getActives() {
        return null;
    }

    @GetMapping("/get/by/customer/name")
    public Order getOrder(@RequestParam("name") String name,
                          @RequestParam("surname") String surname) {
        return null;
    }

    @GetMapping("/get/by/customer/number")
    public Order getOrder(@RequestParam("number") String number) {
        return null;
    }

}
