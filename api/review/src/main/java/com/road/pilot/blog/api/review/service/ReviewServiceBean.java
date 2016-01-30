package com.road.pilot.blog.api.review.service;

import com.road.pilot.blog.api.review.entity.Review;
import com.road.pilot.blog.api.review.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Service
public class ReviewServiceBean implements ReviewService {
    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceBean.class);
    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewServiceBean() {
        logger.debug("Review Service Initialized");
    }

    public List<Review> getReviewByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews;
    }
}
