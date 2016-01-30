package com.road.pilot.blog.api.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by road on 16. 1. 30.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RecommendationApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecommendationApiApplication.class, args);
    }
}
