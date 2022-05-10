package com.generali.burritoorderingservice;

import com.generali.burritoorderingservice.dto.ExtraDto;
import com.generali.burritoorderingservice.dto.OrderDto;
import com.generali.burritoorderingservice.dto.VegetableDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Mocker {
    @Bean
    public OrderDto getMockOrder() {
        OrderDto orderDto = new OrderDto();
        orderDto.setProtein("bean");
        orderDto.setSalsa("hot");
        orderDto.setTortilla("corn");

        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setVegetable("cabbage");
        orderDto.setVegetables(Collections.singletonList(vegetableDto));

        ExtraDto extraDto = new ExtraDto();
        extraDto.setExtra("avocado");
        orderDto.setExtras(Collections.singletonList(extraDto));
        return orderDto;
    }
}
