package com.road.pilot.blog.api.composite.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.road.pilot.blog.api.composite.model.Product;
import com.road.pilot.blog.api.composite.model.Recommendation;
import com.road.pilot.blog.api.composite.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResource extends ResourceSupport {

    private Long productId;

    private String name;

    private Double weight;

    private List<Recommendation> recommendations;

    private List<Review> reviews;

    public ProductResource(Product product) {
        if (product != null) {
            this.productId = product.getId();
            this.name = product.getName();
            this.weight = product.getWeight();
            this.recommendations = product.getRecommendations();
            this.reviews = product.getReviews();
        }
    }
}
