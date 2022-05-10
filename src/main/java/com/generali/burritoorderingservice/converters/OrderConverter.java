package com.generali.burritoorderingservice.converters;

import com.generali.burritoorderingservice.dao.Extras;
import com.generali.burritoorderingservice.dao.Order;
import com.generali.burritoorderingservice.dao.Vegetables;
import com.generali.burritoorderingservice.dto.ExtraDto;
import com.generali.burritoorderingservice.dto.OrderDto;
import com.generali.burritoorderingservice.dto.VegetableDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderConverter {

    public OrderDto convert(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setProtein(order.getProtein());
        orderDto.setSalsa(order.getSalsa());
        orderDto.setTortilla(order.getTortilla());
        orderDto.setExtras(new ArrayList<>());
        orderDto.setVegetables(new ArrayList<>());

        order.getExtras().forEach(extra -> {
            ExtraDto extraDto = new ExtraDto();
            extraDto.setExtra(extra.getExtraType());
            orderDto.getExtras().add(extraDto);
        });

        order.getVegetables().forEach(vegetable -> {
            VegetableDto vegetableDto = new VegetableDto();
            vegetableDto.setVegetable(vegetable.getVegetableType());
            orderDto.getVegetables().add(vegetableDto);
        });
        return orderDto;
    }

    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        order.setProtein(orderDto.getProtein());
        order.setSalsa(orderDto.getSalsa());
        order.setTortilla(orderDto.getTortilla());

        orderDto.getExtras().forEach(extraDto -> {
            Extras extra = new Extras();
            extra.setExtraType(extraDto.getExtra());
            extra.setOrder(order);
            order.getExtras().add(extra);
        });

        orderDto.getVegetables().forEach(vegetableDto -> {
            Vegetables vegetable = new Vegetables();
            vegetable.setVegetableType(vegetableDto.getVegetable());
            vegetable.setOrder(order);
            order.getVegetables().add(vegetable);
        });

        return order;
    }
}
