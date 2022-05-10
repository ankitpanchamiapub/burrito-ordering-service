package com.generali.burritoorderingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generali.burritoorderingservice.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BurritoOrderingServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderDto orderDto;

    @Test
    void contextLoads() {
    }

    @Test
    public void createOrder() throws Exception {
        String json = new ObjectMapper().writeValueAsString(orderDto);

        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void createOrderFailureTest() throws Exception {
        orderDto.setProtein(null);
        String json = new ObjectMapper().writeValueAsString(orderDto);
        try {
            mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isBadRequest())
                    .andExpect(result -> result.equals("createOrder.orderDto.protein: Protein must not be null"));
        } catch (Exception ex) {
            assertTrue(ex instanceof ConstraintViolationException);
        }
    }

    @Test
    public void getOrderValid() throws Exception {
        mockMvc.perform(get("/orders/" + 1))
                .andExpect(status().isFound());
    }

    @Test
    public void getOrderInValid() throws Exception {
        mockMvc.perform(get("/orders/" + (-99)))
                .andExpect(status().isNotFound());
    }

}
