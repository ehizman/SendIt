package com.ehizman.drones.controllers;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.model.mapper.UserMapper;
import com.ehizman.drones.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class AuthControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void testRegisterAUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserRegistrationRequest request = new UserRegistrationRequest("edemaehiz@gmail.com", "password");
        request.setEmail("edemaehiz@gmail.com");
        request.setPassword("password");

        mockMvc.perform(post("/userService/api/v1/user/auth/register")
                .contentType("application/json")
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().is(200))
                .andDo(print());

    }
}