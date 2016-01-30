package com.road.pilot.blog.api.recommendation.controller;

import com.road.pilot.blog.api.recommendation.entity.Recommendation;
import com.road.pilot.blog.api.recommendation.service.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@RestController
@RequestMapping(value = "/")
public class RecommendationController {
    private static final Logger logger = LoggerFactory.getLogger(RecommendationController.class);

    @Autowired
    private RecommendationService recommendationService;

    public RecommendationController() {
        logger.debug("Recommendation Controller Initialized");
    }

    @RequestMapping(value = "/byProduct/{productId}")
    public ResponseEntity<List<Recommendation>> getProductRecommendations(@PathVariable(value = "productId") Long productId) {
        List<Recommendation> recommendations = recommendationService.getProductRecommendations(productId);

        return new ResponseEntity<List<Recommendation>>(recommendations, HttpStatus.OK);
    }

}
