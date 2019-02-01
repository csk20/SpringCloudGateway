package com.gateway.conf;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class HealthCheck implements HealthIndicator {
  
    @Override
    public Health health() {
       System.out.println("in health method");
        return Health.up().build();
    }
}

