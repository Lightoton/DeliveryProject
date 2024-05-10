package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
@WithMockUser(username = "alice", password = "12345", roles = "CLIENT")
class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showRestaurantById() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setRId(UUID.fromString("36313935-3431-3238-2d32-3466662d3435"));
        restaurant.setAddress("123 Main Street, Cityville");
        restaurant.setTitle("Green Leaf Cafe");
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/restaurant/show_restaurant/36313935-3431-3238-2d32-3466662d3435")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String restaurantResultJson = mvcResult.getResponse().getContentAsString();

        Restaurant actual = objectMapper.readValue(restaurantResultJson, Restaurant.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(restaurant, actual);
    }

    @Test
    void createRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setTitle("Test");
        restaurant.setAddress("Test");
        String restaurantWrite = objectMapper.writeValueAsString(restaurant);
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/restaurant/add_restaurant_to_DB")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(restaurantWrite))
                .andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}