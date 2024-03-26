package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.CategoryFood;
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

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class FoodCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showFoodCategoryById() throws Exception {
        CategoryFood categoryFood = new CategoryFood();
        categoryFood.setCategoryId(UUID.fromString("35396330-3466-6237-2d32-3138322d3431"));
        categoryFood.setTitle("Salads");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/food_category/show_food_category/35396330-3466-6237-2d32-3138322d3431")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String foodCategoryResultJson = mvcResult.getResponse().getContentAsString();

        CategoryFood actual = objectMapper.readValue(foodCategoryResultJson, CategoryFood.class);

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(categoryFood,actual);
    }
}