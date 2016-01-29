package com.road.pilot.blog.api.product.entity;

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
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "WEIGHT", nullable = false)
    private Double weight;

}
