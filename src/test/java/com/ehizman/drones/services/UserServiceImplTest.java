package com.ehizman.drones.services;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.exceptions.UserException;
import com.ehizman.drones.model.User;
import com.ehizman.drones.model.mapper.UserMapper;
import com.ehizman.drones.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = DataConfig.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, userMapper, passwordEncoder);
    }

    @Test
    void testThatCanLoadUserByEmail() throws UserException {
        UserRegistrationRequest request = new UserRegistrationRequest("testEmail@gmail.com", "password");
        User user = userMapper.userDtoToUser(request);
        assertEquals("testEmail@gmail.com", user.getEmail());
        assertEquals("password", user.getPassword());
        when(userRepository.save(user)).thenReturn(user);
        UserDTO userDTO = userService.registerUser(request);
        verify(userRepository, times(1)).save(user);
        assertEquals("testEmail@gmail.com", userDTO.getEmail());
    }
}