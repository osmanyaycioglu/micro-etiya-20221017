package org.training.ms.etiya.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.training.ms.etiya.msorder.rest.models.OrderRest;
import org.training.ms.etiya.msorder.rest.models.OrderResult;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/provision")
public class OrderProvisionController {

    // @RequestMapping(value = "/place",method = RequestMethod.POST)
    @PostMapping("/place")
    @Operation(summary = "Sipariş vermek için",description = "Sipariş listesini girilen yer.")
    public OrderResult place(@Valid @RequestBody OrderRest order) {
        return new OrderResult().setOrderId(1L).setDesc("OK");
    }

    @GetMapping("/cancel/{oid}")
    public String cancel(@PathVariable("oid") Long orderId) {
        return "OK";
    }

    @GetMapping("/pause")
    public String pause(@RequestParam("oid") Long orderId) {
        return "OK";
    }

}
