package com.ehizman.drones.services;

import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.exceptions.UserException;
import com.ehizman.drones.model.Role;
import com.ehizman.drones.model.User;
import com.ehizman.drones.model.mapper.UserMapper;
import com.ehizman.drones.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(@Valid  UserRegistrationRequest registrationDetails) throws UserException {
        if (emailExists(registrationDetails.getEmail())){
            throw new UserException("User account already exists");
        }
        User user = userMapper.userDtoToUser(registrationDetails);
        log.info("User --> {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRole(Role.USER);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User with email not found")
        );
    }

    private boolean emailExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByEmail(username);
    }

    private UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format("User with %s not found", email))
                );
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(
                role -> {
                    authorities.addAll(role.getGrantedAuthorities());
                }
        );
        return authorities;
    }
}
