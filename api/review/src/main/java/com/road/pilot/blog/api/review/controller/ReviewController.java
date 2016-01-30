package com.road.pilot.blog.api.review.controller;

import com.road.pilot.blog.api.review.entity.Review;
import com.road.pilot.blog.api.review.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private ReviewService reviewService;

    public ReviewController() {
        logger.debug("Review Controller Initialized");
    }

    @RequestMapping(value = "/byProduct/{productId}")
    public ResponseEntity<List<Review>> getProductReviews(@PathVariable(value = "productId") Long productId) {
        List<Review> reviews = reviewService.getReviewByProductId(productId);
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }
}
