package com.wdg.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * User: wangdaogang
 * Date: 2019/9/16
 * Description: No Description
 */
public interface RawDataService {

    JSONObject importList(MultipartFile file,String operation);
}
