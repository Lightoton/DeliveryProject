package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.deliveryproject.entity.UserInfo;
import de.telran.deliveryproject.exception.UserInformationNotFoundException;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void showUserById() throws Exception {
        UserInfo expected = new UserInfo();
        expected.setInfoId(UUID.fromString("c80d54d3-500d-4539-9479-8e8961477193"));
        expected.setFirstname("Alice");
        expected.setLastname("Smith");
        expected.setEmail("alice@example.com");
        expected.setPhoneNumber("111222333");
        expected.setUsername("alice");
        expected.setPassword("password789");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/user_info/showUserInfo/c80d54d3-500d-4539-9479-8e8961477193")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String userInfoResultJson = mvcResult.getResponse().getContentAsString();

        UserInfo actual = objectMapper.readValue(userInfoResultJson, UserInfo.class);

        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createUserInfo() throws Exception {
        UserInfo expected = new UserInfo();
        expected.setFirstname("Alicia");
        expected.setLastname("Light");
        expected.setEmail("alicia@example.com");
        expected.setPhoneNumber("764322333");
        expected.setUsername("alicia");
        expected.setPassword("mefwoniovr");

        String userInfoToDb = objectMapper.writeValueAsString(expected);

        MvcResult createUserInfoResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/user_info/create_user_info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userInfoToDb))
                .andReturn();

        String userInfoResultJson = createUserInfoResult.getResponse().getContentAsString();

        UserInfo actual = objectMapper.readValue(userInfoResultJson, UserInfo.class);
        Assertions.assertEquals(200, createUserInfoResult.getResponse().getStatus());
        Assertions.assertEquals(expected.getFirstname(), actual.getFirstname());
        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
        Assertions.assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        Assertions.assertEquals(expected.getUsername(), actual.getUsername());
    }

    @Test
    void deleteUserInfoById() throws Exception {
        Assertions.assertEquals(200,mockMvc
                .perform(MockMvcRequestBuilders.delete("/user_info/delete_user_info/c80d54d3-500d-4539-9479-8e8961477193")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getStatus());


        Assertions.assertEquals(404, mockMvc
                    .perform(MockMvcRequestBuilders.get("/user_info/showUserInfo/c80d54d3-500d-4539-9479-8e8961477193")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse().getStatus());
        }
    }
