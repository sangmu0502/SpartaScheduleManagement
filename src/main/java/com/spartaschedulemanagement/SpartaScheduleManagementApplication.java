package com.spartaschedulemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaScheduleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaScheduleManagementApplication.class, args);
    }

}
