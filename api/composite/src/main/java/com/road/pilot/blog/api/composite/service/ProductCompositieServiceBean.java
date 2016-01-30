package com.road.pilot.blog.api.composite.service;

import com.road.pilot.blog.api.composite.model.Product;
import com.road.pilot.blog.api.composite.model.Recommendation;
import com.road.pilot.blog.api.composite.model.Review;
import com.road.pilot.blog.api.composite.util.PageImplBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by road on 16. 1. 30.
 */
@Service
public class ProductCompositieServiceBean implements ProductCompositeService {
    private static final Logger logger = LoggerFactory.getLogger(ProductCompositieServiceBean.class);

    /**
     * Core API 서비스들에 연결하여 데이터를 가져올 각 URL.
     * 해당 정보를 Configuration Properties 로 분리하여 처리하는 것이 맞으나, Sample에서는 static 으로 처리함.
     */
    private static final String PRODUCT_API_URL = "http://product/";
    private static final String RECOMMENDATION_API_URL = "http://recommendation/";
    private static final String REVIEW_API_URL = "http://review/";

    @Autowired
    private RestTemplate restTemplate;

    public ProductCompositieServiceBean() {
        logger.debug("Product Composite Service Implementation Initialized");
    }

    @Override
    public Page<Product> getProducts(int page, int size, String sort) {
        String uri = new StringBuffer(PRODUCT_API_URL).append("/?size={size}&page={page}&sort={sort}").toString();
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("sort", sort);


        ResponseEntity<PageImplBean<Product>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<PageImplBean<Product>>() {
        }, pageMap);

        if (responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        return responseEntity.getBody();
    }

    @Override
    public Product getProductById(Long id) {

        String uri = new StringBuffer(PRODUCT_API_URL).append("/{productId}").toString();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", id);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {}, paramMap);
        if (responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        Product product = responseEntity.getBody();

        Long productId = product.getId();

        List<Recommendation> recommendations = getRecommendationsByProduct(productId);

        product.addRecommenations(recommendations);

        List<Review> reviews = getReviewsByProduct(productId);

        product.addReviews(reviews);

        return responseEntity.getBody();
    }

    private List<Recommendation> getRecommendationsByProduct(Long productId) {
        String uri = new StringBuffer(RECOMMENDATION_API_URL).append("/byProduct/{productId}").toString();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", productId);
        ResponseEntity<List<Recommendation>> responseEntinty = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Recommendation>>(){}, paramMap);

        if(responseEntinty == null || responseEntinty.getStatusCode() != HttpStatus.OK) {
            return new ArrayList<>();
        }

        return responseEntinty.getBody();
    }

    private List<Review> getReviewsByProduct(Long productId) {
        String uri = new StringBuffer(REVIEW_API_URL).append("/byProduct/{productId}").toString();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", productId);

        ResponseEntity<List<Review>> responseEntinty = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>(){}, paramMap);

        if(responseEntinty == null || responseEntinty.getStatusCode() != HttpStatus.OK) {
            return new ArrayList<>();
        }

        return responseEntinty.getBody();
    }
}
