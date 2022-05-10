package com.generali.burritoorderingservice.services.impl;

import com.generali.burritoorderingservice.converters.OrderConverter;
import com.generali.burritoorderingservice.dao.Order;
import com.generali.burritoorderingservice.dto.OrderDto;
import com.generali.burritoorderingservice.repositories.OrderRepository;
import com.generali.burritoorderingservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderDto getOrderById(Long id) {
        try {
            Order order = orderRepository.getById(id);
            if (order == null) {
                return null;
            }
            return orderConverter.convert(order);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderConverter.convert(orderDto);
        orderRepository.save(order);
        return orderConverter.convert(order);
    }

}
