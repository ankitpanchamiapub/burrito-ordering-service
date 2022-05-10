package com.generali.burritoorderingservice.services;

import com.generali.burritoorderingservice.dto.OrderDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface OrderService {
    public OrderDto getOrderById(Long id);

    public OrderDto createOrder(@Valid OrderDto orderDto);
}
