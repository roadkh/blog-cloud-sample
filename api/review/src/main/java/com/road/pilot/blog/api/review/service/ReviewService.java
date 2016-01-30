package com.road.pilot.blog.api.review.service;

import com.road.pilot.blog.api.review.entity.Review;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
public interface ReviewService {
    List<Review> getReviewByProductId(Long productId);
}
