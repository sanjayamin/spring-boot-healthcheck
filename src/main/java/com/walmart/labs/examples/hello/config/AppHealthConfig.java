package com.walmart.labs.examples.hello.config;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.walmart.labs.examples.hello.health.AppHealthIndicator;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class AppHealthConfig {

    @Bean
    public HealthIndicator appHealthIndicator() {
        return new AppHealthIndicator();
    }
    
    @Bean
    public MetricsEndpoint metricsEndpoint(MeterRegistry registry) {
        return new MetricsEndpoint(registry);
    }

}