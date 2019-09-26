package com.wdg.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentClear();
    }
}
