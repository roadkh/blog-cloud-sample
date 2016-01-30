package com.road.pilot.blog.api.recommendation.service;

import com.road.pilot.blog.api.recommendation.entity.Recommendation;
import com.road.pilot.blog.api.recommendation.repository.RecommendationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Service
public class RecommendationServiceBean implements RecommendationService {
    private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceBean.class);

    @Autowired
    private RecommendationRepository recommendationRepository;

    public RecommendationServiceBean() {
        logger.debug("Recommendation Service initialized");
    }

    public List<Recommendation> getProductRecommendations(Long productId) {
        List<Recommendation> recommendations = recommendationRepository.findByProductId(productId);
        return recommendations;
    }
}
