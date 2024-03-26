package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Food;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class FoodControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showFoodById() throws Exception {
        Food food = new Food();
        food.setFId(UUID.fromString("63623962-6466-3665-2d33-3438382d3434"));
        food.setCalorie(350.0);
        food.setPrice(BigDecimal.valueOf(12.99));
        food.setTitle("Grilled Chicken Salad");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/food/show_food/63623962-6466-3665-2d33-3438382d3434")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String foodResultJson = mvcResult.getResponse().getContentAsString();

        Food actual = objectMapper.readValue(foodResultJson, Food.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(food,actual);
    }

    @Test
    void showAllFoodsByMenuId() throws Exception {
        List<Food> foods = Arrays.asList(new Food(),new Food());

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/food/show_foods_by_menu/38616361-3138-3434-2d61-3261312d3466")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String foodsResultJson = mvcResult.getResponse().getContentAsString();
        Food[] actual = objectMapper.readValue(foodsResultJson,Food[].class);
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(foods.size(),actual.length);
    }
}