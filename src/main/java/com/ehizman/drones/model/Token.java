package com.ehizman.drones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

public class Token {
    @Id
    private String id;
    private String token;
    private TokenType type;
    @DBRef
    private User user;
    private LocalDateTime expiry;
}

