package com.friv.clone.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> Health.up()
                .withDetail("app", "Friv Clone Backend")
                .withDetail("version", "1.0.0")
                .withDetail("environment", "Production")
                .build();
    }
} 