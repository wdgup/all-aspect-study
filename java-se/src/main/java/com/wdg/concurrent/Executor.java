package com.wdg.concurrent;

import com.wdg.common.Result;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * User: wangdaogang
 * Date: 2019/9/10
 * Description: No Description
 */
public class Executor implements Callable<Result> {

    private Map<String,Object> params;

    public Executor(Map<String,Object> params){
        this.params = params;
    }
    public Result call() throws Exception {
        System.out.println(Thread.currentThread().getName()+":执行call方法");

        Result<Map<String,Object>> result  = new Result<Map<String, Object>>();
        result.setCode("200");
        result.setMessage("success");
        result.setData(params);
        return result;
    }
}
