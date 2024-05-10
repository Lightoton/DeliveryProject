package de.telran.deliveryproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import de.telran.deliveryproject.dto.ClientDto;
import de.telran.deliveryproject.dto.UserInfoDto;
import de.telran.deliveryproject.entity.Client;
import de.telran.deliveryproject.entity.enums.Rating;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/drop_test_tables.sql")
@Sql("/create_test_tables.sql")
@Sql("/insert_test_data.sql")
@WithMockUser(username = "alice", password = "12345", roles = "CLIENT")
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID testUUID = UUID.fromString("62656630-3736-6434-2d39-6135342d3439");

    @Test
    void showClientById() throws Exception {
        Client expected = new Client();
        expected.setUId(testUUID);
        expected.setRating(Rating.STAR5);
        expected.setAddress("123 Main Street");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/client/show_client/62656630-3736-6434-2d39-6135342d3439")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String clientResultJson = mvcResult.getResponse().getContentAsString();

        Client actual = objectMapper.readValue(clientResultJson, Client.class);
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expected, actual);


    }

    @Test
    void createClient() throws Exception {
        ClientDto clientDto = getClient();
        String clientWrite = objectMapper.writeValueAsString(clientDto);
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/client/create_client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientWrite))
                .andReturn();
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void updateClientById() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/client/show_client/62656630-3736-6434-2d39-6135342d3439")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String clientJSON = mvcResult.getResponse().getContentAsString();
        Client client = objectMapper.readValue(clientJSON, Client.class);
        client.setRating(Rating.STAR0);

        String updatedClientJSON = objectMapper.writeValueAsString(client);

        MvcResult updateResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/client/update_client/62656630-3736-6434-2d39-6135342d3439")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedClientJSON))
                .andExpect(status().isOk())
                .andReturn();

        String updatedClientFromDB = updateResult.getResponse().getContentAsString();
        Client clientFromDB = objectMapper.readValue(updatedClientFromDB, Client.class);

        Assertions.assertEquals(client,clientFromDB);
    }

    private static ClientDto getClient(){
        Faker faker = new Faker();
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setPhoneNumber(faker.phoneNumber().phoneNumber().substring(0,10));
        userInfoDto.setUsername(faker.funnyName().name());
        userInfoDto.setEmail("test@gmail.com");
        userInfoDto.setFirstname(faker.name().firstName());
        userInfoDto.setLastname(faker.name().lastName());
        ClientDto clientDto = new ClientDto();
        clientDto.setRoleName("User");
        clientDto.setDateOfBirth("1997-12-19");
        clientDto.setAddress(faker.address().fullAddress());
        clientDto.setUserInfo(userInfoDto);
        clientDto.setDepartmentId("62363334-6261-3130-2d33-3436362d3437");
        return clientDto;
    }
}