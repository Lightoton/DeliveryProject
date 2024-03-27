package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Order;
import de.telran.deliveryproject.entity.enums.StatusOrder;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showFoodById() throws Exception {
        Order order = new Order();
        order.setId(UUID.fromString("32323231-3033-6566-2d62-3233622d3438"));
        order.setStatusOrder(StatusOrder.AWAITING_PAYMENT);
        order.setFinalAmount(BigDecimal.valueOf(25.99));

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/order/show_order/32323231-3033-6566-2d62-3233622d3438")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String orderResultJson = mvcResult.getResponse().getContentAsString();

        Order actual = objectMapper.readValue(orderResultJson, Order.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(order,actual);
    }

    @Test
    void deleteOrderById() throws Exception {
        Assertions.assertEquals(200,mockMvc
                .perform(MockMvcRequestBuilders.delete("/order/delete_order/32323231-3033-6566-2d62-3233622d3438")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getStatus());
        Assertions.assertThrows(ServletException.class,()-> mockMvc
                .perform(MockMvcRequestBuilders.get("/order/show_order/32323231-3033-6566-2d62-3233622d3438")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn());
    }

    @Test
    void createOrder() {

    }
}