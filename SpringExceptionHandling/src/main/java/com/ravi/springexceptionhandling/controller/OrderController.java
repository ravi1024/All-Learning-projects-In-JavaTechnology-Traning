package com.ravi.springexceptionhandling.controller;

import com.ravi.springexceptionhandling.exception.OrderNotFoundException;
import com.ravi.springexceptionhandling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/orders/{orderName}")
    public String getOrderPrice(@PathVariable String orderName) throws OrderNotFoundException {

        double amount = orderService.getPriceOfOrder(orderName);
        return "Product amount of " + orderName + " is " + amount;
    }
}
