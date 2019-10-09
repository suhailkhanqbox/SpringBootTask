package com.stackroute.userservice;

import com.stackroute.userservice.startup.StartupDatabaseSeederApproach2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StartupDatabaseSeederApproach2.class)
public class UserService {
    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
