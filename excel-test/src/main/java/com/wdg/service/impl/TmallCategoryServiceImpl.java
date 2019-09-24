package com.wdg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wdg.service.TmallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wangdaogang
 * Date: 2019/9/24
 * Description: No Description
 */
@Service
public class TmallCategoryServiceImpl implements TmallCategoryService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<JSONObject> categoryList(String shopId) {
        return null;
    }
}
