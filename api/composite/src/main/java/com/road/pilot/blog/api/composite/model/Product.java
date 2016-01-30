package com.road.pilot.blog.api.composite.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private Long id;

    private String name;

    private Double weight;

    private List<Recommendation> recommendations;

    private List<Review> reviews;

    public void addReviews(List<Review> reviews) {
        if (this.reviews == null) {
            this.reviews = new ArrayList<>();
        }

        this.reviews.addAll(reviews);
    }

    public void addRecommenations(List<Recommendation> recommendations) {
        if (this.recommendations == null) {
            this.recommendations = new ArrayList<>();
        }

        this.recommendations.addAll(recommendations);
    }
}
