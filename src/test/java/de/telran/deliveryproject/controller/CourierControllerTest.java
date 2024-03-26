package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Courier;
import de.telran.deliveryproject.entity.enums.Rating;
import de.telran.deliveryproject.entity.enums.StatusCourier;
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
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class CourierControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void showCourierById() throws Exception {
         Courier expected = new Courier();
         expected.setCId(UUID.fromString("32383661-6264-3439-2d61-3835622d3466"));
         expected.setStatusCourier(StatusCourier.FREE);
         expected.setRating(Rating.STAR7);
         expected.setSalary(BigDecimal.valueOf(2500.0));
         expected.setStatusEmployee(StatusEmployee.WORK);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/courier/show_courier/32383661-6264-3439-2d61-3835622d3466")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String courierResultJson = mvcResult.getResponse().getContentAsString();
        Courier actual = objectMapper.readValue(courierResultJson, Courier.class);
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void showCourierByName() throws Exception {
        Courier expected = new Courier();
        expected.setCId(UUID.fromString("32383661-6264-3439-2d61-3835622d3466"));
        expected.setStatusCourier(StatusCourier.FREE);
        expected.setRating(Rating.STAR7);
        expected.setSalary(BigDecimal.valueOf(2500.0));
        expected.setStatusEmployee(StatusEmployee.WORK);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/courier/show_courier_by_name/Michael")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String courierResultJson = mvcResult.getResponse().getContentAsString();
        Courier actual = objectMapper.readValue(courierResultJson, Courier.class);
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void showFreeCouriers() throws Exception {
        List<Courier> couriers = new ArrayList<>();
        couriers.add(new Courier());
        couriers.add(new Courier());
        couriers.add(new Courier());

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/courier/show_free_couriers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String courierResultJson = mvcResult.getResponse().getContentAsString();
        Courier[] actual = objectMapper.readValue(courierResultJson, Courier[].class);


        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(couriers.size(),actual.length);
    }
}