package com.road.pilot.blog.api.product.controller;

import com.road.pilot.blog.api.product.entity.Product;
import com.road.pilot.blog.api.product.service.ProductService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by road on 16. 1. 30.
 */
@RestController
@RequestMapping(value = "/")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    public ProductController() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllProduct(@PageableDefault Pageable pageable) {

        Page<Product> products = productService.getProductList(pageable);
        logger.info(ToStringBuilder.reflectionToString(products, ToStringStyle.MULTI_LINE_STYLE));
        return new ResponseEntity<Page<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
