package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.Department;
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
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void showDepartmentById() throws Exception {
        Department department = new Department();
        department.setDId(UUID.fromString("62363334-6261-3130-2d33-3436362d3437"));
        department.setAddress("123 Main Street");
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/department/show_department/62363334-6261-3130-2d33-3436362d3437")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String departmentResultJson = mvcResult.getResponse().getContentAsString();

        Department actual = objectMapper.readValue(departmentResultJson, Department.class);
        Assertions.assertEquals(200,mvcResult.getResponse().getStatus());
        Assertions.assertEquals(department,actual);
    }
}