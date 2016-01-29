package com.road.pilot.blog.api.product.service;

import com.road.pilot.blog.api.product.entity.Product;
import com.road.pilot.blog.api.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by road on 16. 1. 30.
 */
@Service
public class ProductServiceBean implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceBean.class);

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceBean() {
    }

    @Override
    public Page<Product> getProductList(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);
        return product;
    }
}
