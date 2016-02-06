package com.road.pilot.blog.api.composite.service;

import com.road.pilot.blog.api.composite.model.Product;
import com.road.pilot.blog.api.composite.model.Recommendation;
import com.road.pilot.blog.api.composite.model.Review;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
public interface ProductCompositeService {
    Page<Product> getProducts(int page, int size, String sort);
    Product getProductById(Long id);
    List<Recommendation> getRecommendationsByProduct(Long productId);
    List<Review> getReviewsByProduct(Long productId);
}
