package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.Menu;
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
class MenuControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showMenuById() throws Exception {
        Menu menu = new Menu();
        menu.setMenuId(UUID.fromString("38616361-3138-3434-2d61-3261312d3466"));
        menu.setTitle("Healthy Choices");
        menu.setAveragePrice(BigDecimal.valueOf(13.49));

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/menu/show_menu_by_id/38616361-3138-3434-2d61-3261312d3466")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String menuResultJson = mvcResult.getResponse().getContentAsString();

        Menu actual = objectMapper.readValue(menuResultJson, Menu.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(menu,actual);
    }
}