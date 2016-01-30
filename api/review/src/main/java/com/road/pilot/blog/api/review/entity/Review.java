package com.road.pilot.blog.api.review.entity;

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
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "CONTENT")
    private String content;
}
