package com.ehizman.drones.controllers;

import com.ehizman.drones.controllers.requests.LoginRequest;
import com.ehizman.drones.controllers.requests.UserRegistrationRequest;
import com.ehizman.drones.controllers.responses.APIResponse;
import com.ehizman.drones.controllers.responses.AuthToken;
import com.ehizman.drones.dtos.UserDTO;
import com.ehizman.drones.exceptions.UserException;
import com.ehizman.drones.model.User;
import com.ehizman.drones.security.jwt.TokenProviderImpl;
import com.ehizman.drones.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/userService/api/v1/user/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    private TokenProviderImpl tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @NotNull @RequestBody UserRegistrationRequest registrationRequest){
        try {
            UserDTO userDTO = userService.registerUser(registrationRequest);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody @Valid LoginRequest loginRequest){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateJWTToken(authentication);
        log.info("Token --> {}", token);
        User user = userService.findUserByEmail(loginRequest.getEmail());
        return new ResponseEntity<>(new AuthToken(token, user.getId()), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }));
        return errors;
    }
}
