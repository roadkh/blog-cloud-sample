package com.road.pilot.blog.api.recommendation.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by road on 16. 1. 30.
 */
@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@Table(name = "RECOMMENDATION")
public class Recommendation {
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "RATE")
    private int rate = 0;

    @Column(name = "CONTENT")
    private String content;
}
