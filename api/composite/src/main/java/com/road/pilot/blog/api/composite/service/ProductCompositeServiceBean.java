package com.road.pilot.blog.api.composite.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class ProductCompositeServiceBean implements ProductCompositeService {
    private static final Logger logger = LoggerFactory.getLogger(ProductCompositeServiceBean.class);

    /**
     * Core API 서비스들에 연결하여 데이터를 가져올 각 URL.
     * 해당 정보를 Configuration Properties 로 분리하여 처리하는 것이 맞으나, Sample에서는 static 으로 처리함.
     */
    private static final String PRODUCT_API_URL = "http://product/";
    private static final String RECOMMENDATION_API_URL = "http://recommendation/";
    private static final String REVIEW_API_URL = "http://review/";

    @Autowired
    private RestTemplate restTemplate;

    public ProductCompositeServiceBean() {
        logger.debug("Product Composite Service Implementation Initialized");
    }

    /**
     * Product list 에 대한 fallback method
     * @param page
     * @param size
     * @param sort
     * @return
     */
    public Page<Product> getDefaultProducts(int page, int size, String sort) {
        logger.debug("page : {}, size : {}", page, size);

        return new PageImplBean<Product>();
    }

    /**
     * Product list 를 조회하는 API Service Method.
     *
     * @param page
     * @param size
     * @param sort
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultProducts")
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

    /**
     * Product 상세에 대한 fallback method.
     * 요청한 아이디를 가지고 나머지 정보다 모두 없는 객체를 리턴하도록 처리하였음.
     *
     * @param id
     * @return
     */
    public Product getDefaultProduct(Long id) {
        logger.debug("Request product id : {}. but return default result.");
        return new Product(id, "", 0d, new ArrayList<>(), new ArrayList<>());
    }


    /**
     * Product 상세 정보를 조회하는 API Service Method.
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultProduct")
    @Override
    public Product getProductById(Long id) {

        String uri = new StringBuffer(PRODUCT_API_URL).append("/{productId}").toString();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", id);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {}, paramMap);
        if (responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK) {
            return null;
        }

        // Hystrix fallback을 정상적으로 적용하기 위해서 Controller로 로직을 이전함.
//        Product product = responseEntity.getBody();
//
//        Long productId = product.getId();
//
//        List<Recommendation> recommendations = getRecommendationsByProduct(productId);
//
//        product.addRecommenations(recommendations);
//
//        List<Review> reviews = getReviewsByProduct(productId);
//
//        product.addReviews(reviews);

        return responseEntity.getBody();
    }

    /**
     * 빈 Recommendation list 를 리턴하는 fallback method
     * @param productId
     * @return
     */
    public List<Recommendation> getDefaultRecommendations(Long productId) {
        return new ArrayList<>();
    }

    /**
     * product 에 해당하는 Recommendation list 를 조회하는 API Service Method.
     * @param productId
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultRecommendations")
    @Override
    public List<Recommendation> getRecommendationsByProduct(Long productId) {
        String uri = new StringBuffer(RECOMMENDATION_API_URL).append("/byProduct/{productId}").toString();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", productId);
        ResponseEntity<List<Recommendation>> responseEntinty = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Recommendation>>(){}, paramMap);

        if(responseEntinty == null || responseEntinty.getStatusCode() != HttpStatus.OK) {
            return new ArrayList<>();
        }

        return responseEntinty.getBody();
    }

    /**
     * 빈 Review list 를 리턴하는 fallback method
     * @param productId
     * @return
     */
    public List<Review> getDefaultReviews(Long productId) {
        return new ArrayList<>();
    }

    /**
     * product 에 해당하는 Review list 를 조회하는 API Service Method.
     * @param productId
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultReviews")
    @Override
    public List<Review> getReviewsByProduct(Long productId) {
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
