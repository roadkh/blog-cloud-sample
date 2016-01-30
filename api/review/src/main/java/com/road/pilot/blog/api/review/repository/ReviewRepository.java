package com.road.pilot.blog.api.review.repository;

import com.road.pilot.blog.api.review.entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    List<Review> findByProductId(Long productId);
}
