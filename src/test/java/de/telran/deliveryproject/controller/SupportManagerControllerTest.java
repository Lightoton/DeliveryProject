package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Food;
import de.telran.deliveryproject.entity.SupportManager;
import de.telran.deliveryproject.entity.enums.StatusEmployee;
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
class SupportManagerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showSupportManagerById() throws Exception {
        SupportManager manager = new SupportManager();
        manager.setSmId(UUID.fromString("66663837-6335-3235-2d35-6432322d3438"));
        manager.setSalary(BigDecimal.valueOf(3500.0));
        manager.setStatusEmployee(StatusEmployee.WORK);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/support_manager/show_support_manager/66663837-6335-3235-2d35-6432322d3438")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String supManagerResultJson = mvcResult.getResponse().getContentAsString();

        SupportManager actual = objectMapper.readValue(supManagerResultJson, SupportManager.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(manager, actual);
    }
}