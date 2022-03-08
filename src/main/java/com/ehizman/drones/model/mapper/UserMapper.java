package com.ehizman.drones.model.mapper;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({})
    User userDtoToUser(UserRegistrationRequest userRegistrationRequest);

    @Mappings({})
    UserDTO userToUserResponseDto(User user);
}
