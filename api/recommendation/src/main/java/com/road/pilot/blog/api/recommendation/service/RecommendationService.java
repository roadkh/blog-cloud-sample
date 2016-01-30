package com.road.pilot.blog.api.recommendation.service;

import com.road.pilot.blog.api.recommendation.entity.Recommendation;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
public interface RecommendationService {

    List<Recommendation> getProductRecommendations(Long productId);
}
