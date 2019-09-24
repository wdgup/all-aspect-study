package com.wdg.controller;

import com.alibaba.fastjson.JSONObject;
import com.wdg.service.RawDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * User: wangdaogang
 * Date: 2019/9/16
 * Description: No Description
 */
@RestController
@RequestMapping("/row-data")
public class RawDataController {

    @Autowired
    private RawDataService rawDataService;
    @PostMapping("/importList")
    public JSONObject importList(MultipartFile file,String operation){
        JSONObject jsonObject;
        if(!StringUtils.isNotBlank(operation)){
            jsonObject = new JSONObject();
            jsonObject.put("message","运营主体不能为空");
        }
        jsonObject = rawDataService.importList(file,operation);
        return jsonObject;
    }
}
