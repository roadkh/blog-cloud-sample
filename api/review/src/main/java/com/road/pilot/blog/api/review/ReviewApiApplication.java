package com.road.pilot.blog.api.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by road on 16. 1. 30.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ReviewApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApiApplication.class, args);
    }
}
