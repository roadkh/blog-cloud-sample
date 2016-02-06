package com.road.pilot.blog.service.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * Created by road on 16. 2. 7.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineAmqp
public class TurbineServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineServiceApplication.class, args);
    }
}
