package com.road.pilot.blog.api.composite.model;

import lombok.*;

/**
 * Created by road on 16. 1. 30.
 */
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recommendation {
    private Long id;

    private Long productId;

    private String author;

    private int rate = 0;

    private String content;
}
