package org.training.ms.etiya.msorder.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.training.ms.etiya.msorder.rest.models.OrderRest;
import org.training.ms.etiya.msorder.rest.models.mappers.IOrderMapper;
import org.training.ms.etiya.msorder.services.OrderQueryService;
import org.training.ms.etiya.msorder.services.models.Order;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryController {

    @Autowired
    private OrderQueryService orderQueryService;

    @GetMapping("/get/one/{oid}")
    public OrderRest getOrder(@PathVariable("oid") Long orderId) {
        return IOrderMapper.ORDER_MAPPER.toOrderRest(orderQueryService.getOne(orderId));
    }

    @GetMapping("/get/all")
    public List<OrderRest> getAll() {
        return IOrderMapper.ORDER_MAPPER.toOrderRests(orderQueryService.getAll());
    }

    @GetMapping("/get/actives")
    public List<OrderRest> getActives() {
        return IOrderMapper.ORDER_MAPPER.toOrderRests(orderQueryService.getActiveOrders());
    }

    @GetMapping("/get/by/customer/name")
    public OrderRest getOrder(@RequestParam("name") String name,
                          @RequestParam("surname") String surname) {
        return null;
    }

    @GetMapping("/get/by/customer/number")
    public List<OrderRest> getOrder(@RequestParam("number") String number) {
        return IOrderMapper.ORDER_MAPPER.toOrderRests(orderQueryService.getOrderByNumber(number));
    }

}
