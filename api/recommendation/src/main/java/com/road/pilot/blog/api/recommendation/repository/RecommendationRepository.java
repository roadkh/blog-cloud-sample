package com.road.pilot.blog.api.recommendation.repository;

import com.road.pilot.blog.api.recommendation.entity.Recommendation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Repository
public interface RecommendationRepository extends PagingAndSortingRepository<Recommendation, Long> {
    List<Recommendation> findByProductId(Long productId);
}
