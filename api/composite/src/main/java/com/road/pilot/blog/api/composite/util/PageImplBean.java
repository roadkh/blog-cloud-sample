package com.road.pilot.blog.api.composite.util;

import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;

/**
 * Created by road on 16. 1. 30.
 */
public class PageImplBean<T> extends PageImpl<T> {

    public PageImplBean() {
        super(new ArrayList<T>());
    }
}
