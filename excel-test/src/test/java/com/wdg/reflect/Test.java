package com.wdg.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: wangdaogang
 * Date: 2019/9/23
 * Description: No Description
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Demo demo = new Demo();
        Method setName = demo.getClass().getDeclaredMethod("setName", String.class);
        setName.invoke(demo, "张三");
        System.out.println(demo);
    }
}
