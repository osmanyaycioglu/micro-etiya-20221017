package org.training.ms.etiya.msorder.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order/provision")
public class OrderProvisionController2 {

    // @RequestMapping(value = "/place",method = RequestMethod.POST)
    @PutMapping
    public String place(String order){
        return "OK";
    }

    @DeleteMapping
    public String cancel(Long orderId){
        return "OK";
    }

}
