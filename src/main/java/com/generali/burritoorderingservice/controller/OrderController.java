package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.dto.OrderDto;
import com.generali.burritoorderingservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity createOrder(@RequestBody OrderDto order) {
        try {
            return new ResponseEntity<OrderDto>(orderService.createOrder(order), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        if (order == null) {
            return new ResponseEntity<OrderDto>(order, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDto>(order, HttpStatus.FOUND);
    }
}
