package com.road.pilot.blog.api.product.service;

import com.road.pilot.blog.api.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by road on 16. 1. 30.
 */
public interface ProductService {

    Page<Product> getProductList(Pageable pageable);

    Product getProductById(Long id);
}
