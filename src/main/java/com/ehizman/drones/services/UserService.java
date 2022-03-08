package com.ehizman.drones.services;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.exceptions.UserException;
import com.ehizman.drones.model.User;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequest registrationDetails) throws UserException;
    User findUserByEmail(String email);
}
