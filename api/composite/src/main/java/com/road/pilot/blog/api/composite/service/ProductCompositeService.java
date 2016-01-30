package com.road.pilot.blog.api.composite.service;

import com.road.pilot.blog.api.composite.model.Product;
import org.springframework.data.domain.Page;

/**
 * Created by road on 16. 1. 30.
 */
public interface ProductCompositeService {
    Page<Product> getProducts(int page, int size, String sort);
    Product getProductById(Long id);
}
