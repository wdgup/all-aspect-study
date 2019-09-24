package com.wdg.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * User: wangdaogang
 * Date: 2019/9/24
 * Description: No Description
 */
public interface TmallCategoryService {

    List<JSONObject> categoryList(String shopId);
}
