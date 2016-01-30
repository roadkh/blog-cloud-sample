package com.road.pilot.blog.api.composite.assembler;

import com.road.pilot.blog.api.composite.controller.ProductCompositeController;
import com.road.pilot.blog.api.composite.model.Product;
import com.road.pilot.blog.api.composite.resource.ProductResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by road on 16. 1. 30.
 */
@Component
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, ProductResource> {
    public ProductResourceAssembler() {
        super(ProductCompositeController.class, ProductResource.class);
    }

    @Override
    protected ProductResource instantiateResource(Product entity) {
        ProductResource resource = new ProductResource(entity);
        return resource;
    }

    @Override
    public ProductResource toResource(Product entity) {
        ProductResource resource = createResourceWithId(entity.getId(), entity);
        return resource;
    }

    @Override
    public List<ProductResource> toResources(Iterable<? extends Product> entities) {
        return super.toResources(entities);
    }
}
