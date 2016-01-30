package com.road.pilot.blog.api.composite.controller;

import com.road.pilot.blog.api.composite.assembler.ProductResourceAssembler;
import com.road.pilot.blog.api.composite.model.Product;
import com.road.pilot.blog.api.composite.resource.ProductResource;
import com.road.pilot.blog.api.composite.service.ProductCompositeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by road on 16. 1. 30.
 */
@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductCompositeController {
    private static final Logger logger = LoggerFactory.getLogger(ProductCompositeController.class);

    @Autowired
    private ProductResourceAssembler productResourceAssembler;

    @Autowired
    private PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    private ProductCompositeService productCompositeService;

    public ProductCompositeController() {
        logger.debug("Product Composite Controller Initialized");
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PagedResources<ProductResource>> getAllProducts(
            @RequestParam(value="page", required = false, defaultValue = "0") int page,
            @RequestParam(value="size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort) {
        Page<Product> products = productCompositeService.getProducts(page, size, sort);
        if (products == null) {
            return new ResponseEntity<PagedResources<ProductResource>>(HttpStatus.NOT_FOUND );
        }

        PagedResources<ProductResource> resources = pagedResourcesAssembler.toResource(products, productResourceAssembler);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResource> getProductById(@PathVariable(value = "id") Long id) {
        Product product = productCompositeService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<ProductResource>(HttpStatus.NOT_FOUND);
        }

        ProductResource resource = productResourceAssembler.toResource(product);

        return new ResponseEntity<ProductResource>(resource, HttpStatus.OK);
    }
}
