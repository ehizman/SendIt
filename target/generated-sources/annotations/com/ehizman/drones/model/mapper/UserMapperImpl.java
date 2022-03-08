package com.ehizman.drones.model.mapper;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-08T15:38:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserRegistrationRequest userRegistrationRequest) {
        if ( userRegistrationRequest == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userRegistrationRequest.getEmail() );
        user.setPassword( userRegistrationRequest.getPassword() );

        return user;
    }

    @Override
    public UserDTO userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }
}
