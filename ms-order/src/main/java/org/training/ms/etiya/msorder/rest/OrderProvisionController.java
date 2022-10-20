package org.training.ms.etiya.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.ms.etiya.msorder.rest.models.OrderRest;
import org.training.ms.etiya.msorder.rest.models.OrderResult;
import org.training.ms.etiya.msorder.rest.models.mappers.IOrderMapper;
import org.training.ms.etiya.msorder.services.OrderProcessService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/provision")
@RefreshScope
public class OrderProvisionController {

    @Autowired
    private OrderProcessService orderProcessService;

    // @RequestMapping(value = "/place",method = RequestMethod.POST)
    @PostMapping("/place1")
    @Operation(summary = "Sipariş vermek için",description = "Sipariş listesini girilen yer.")
    public OrderResult place1(@Valid @RequestBody OrderRest order) {
        String aStr = orderProcessService.addOrder(IOrderMapper.ORDER_MAPPER.toOrder(order));
        return new OrderResult().setOrderId(1L).setDesc(aStr);
    }

    @PostMapping("/place2")
    public OrderResult place2(@Valid @RequestBody OrderRest order) {
        String aStr = orderProcessService.addOrder2(IOrderMapper.ORDER_MAPPER.toOrder(order));
        return new OrderResult().setOrderId(1L).setDesc(aStr);
    }

    @PostMapping("/place3")
    public OrderResult place3(@Valid @RequestBody OrderRest order) {
        String aStr = orderProcessService.addOrder3(IOrderMapper.ORDER_MAPPER.toOrder(order));
        return new OrderResult().setOrderId(1L).setDesc(aStr);
    }

    @GetMapping("/cancel/{oid}")
    public String cancel(@PathVariable("oid") Long orderId) {
        orderProcessService.cancelOrder(orderId);
        return "Canceled";
    }

    @GetMapping("/pause")
    public String pause(@RequestParam("oid") Long orderId) {

        orderProcessService.pauseOrder(orderId);
        return "Paused";
    }

}
