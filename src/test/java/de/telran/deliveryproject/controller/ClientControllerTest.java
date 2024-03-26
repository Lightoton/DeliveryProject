package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.entity.enums.Rating;
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

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showClientById() throws Exception {
        Client expected = new Client();
        expected.setUId(UUID.fromString("62656630-3736-6434-2d39-6135342d3439"));
        expected.setRating(Rating.STAR5);
        expected.setAddress("123 Main Street");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/client/show_client/62656630-3736-6434-2d39-6135342d3439")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String clientResultJson = mvcResult.getResponse().getContentAsString();

        Client actual = objectMapper.readValue(clientResultJson, Client.class);
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expected,actual);


    }
}