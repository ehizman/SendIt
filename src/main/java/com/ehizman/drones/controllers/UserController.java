package com.ehizman.drones.controllers;

import com.ehizman.drones.model.Drone;
import com.ehizman.drones.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userService/api/v1/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    DroneService droneService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/drones/all")
    public ResponseEntity<?> viewAllDrones() {
        List<Drone> drones = droneService.findAllDrones();
        if (drones == null){
            return new ResponseEntity<>("No drones are available at this time", HttpStatus.OK);
        }
        return new ResponseEntity<>(drones, HttpStatus.OK);
    }
}
