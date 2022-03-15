package com.ehizman.drones.config;

import com.ehizman.drones.model.Drone;
import com.ehizman.drones.model.Role;
import com.ehizman.drones.model.User;
import com.ehizman.drones.repositories.DroneRepository;
import com.ehizman.drones.repositories.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    private final UserRepository userRepository;
    private final DroneRepository droneRepository;
    private final PasswordEncoder passwordEncoder;


    public SetupDataLoader(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           DroneRepository droneRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.droneRepository = droneRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) return;
        //create admin user
        if (userRepository.findUserByEmail("drones_admin@gmail.com").isEmpty()){
            User admin = new User();
            admin.setEmail("drones_admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin_password_#"));
            admin.setRoles(Sets.newHashSet(Role.ADMIN));
            admin.setEnabled(true);
            admin.setDeliveryHistory(Sets.newHashSet());
            userRepository.save(admin);
        }
        //load drones
        if (droneRepository.findAll().isEmpty()){
            Drone drone1 = new Drone("LARGE");
            Drone drone2 = new Drone("MEDIUM");
            Drone drone3 = new Drone("SMALL");
            droneRepository.saveAll(List.of(drone1, drone2, drone3));
        }
        alreadySetup = true;
    }
}