package com.road.pilot.blog.api.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by road on 16. 1. 30.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CompositeApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompositeApiApplication.class, args);
    }
}
