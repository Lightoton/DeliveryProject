package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Manager;
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
class ManagerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showManagerById() throws Exception {
        Manager manager = new Manager();
        manager.setMId(UUID.fromString("66393734-3665-3734-2d33-3731322d3439"));
        manager.setSalary(BigDecimal.valueOf(4000.0));


        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/manager/show_manager/66393734-3665-3734-2d33-3731322d3439")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String managerResultJson = mvcResult.getResponse().getContentAsString();

        Manager actual = objectMapper.readValue(managerResultJson, Manager.class);

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(manager,actual);
    }
}