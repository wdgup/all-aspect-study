package com.wdg.context;

import com.wdg.bean.BeanConstans;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class ApplicationContext {


    private static Document config;


    static {
        SAXReader saxReader = new SAXReader();
        try {

            config = saxReader.read("/Users/wangdaogang/workspace/all-aspect-study/spring-core/src/main/resources/applicationContext.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //1.
    public Object getBean(String beanId) throws Exception {
        Assert.notNull(beanId,"beanId must not be null");
        Element rootElement = config.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element element = (Element) iterator.next();
            String idValue = element.attributeValue(BeanConstans.BEAN_ID);
            if(beanId.equals(idValue)){
                Class<?> aClass = Class.forName(element.attributeValue(BeanConstans.BEAN_CLASS));
                Object o = aClass.newInstance();
                List<Element> propertys = element.elements(BeanConstans.BEAN_PROPERTY);
                if(Objects.nonNull(propertys) || !propertys.isEmpty()){
                    Map<String, Object> map = getBeanProperty(propertys);
                    reflectSetProperty(o, aClass, map);
                }
                return o;
            }

        }
        return null;
    }

    private Map<String,Object> getBeanProperty(List<Element> propertys){
        Map<String,Object> map = new HashMap<>();
        propertys.stream().forEach(property->
        {
            String propertyName = property.attributeValue(BeanConstans.BEAN_PROPERTY_NAME);
            Object propertyValue = property.attributeValue(BeanConstans.BEAN_PROPERTY_VALUE);
            map.put(propertyName,propertyValue);

        });
        return map;
    }

    private void reflectSetProperty(Object target,Class aClass,Map<String,Object> propertyMap) throws Exception {
        Field[] fields = aClass.getDeclaredFields();
        //判断属性值 是否存在
        for(Field field : fields){
            String sourceName = field.getName();
            for(Map.Entry entry : propertyMap.entrySet()){
                if(sourceName.equals(entry.getKey())){
                    Class<?> type = field.getType();
                    field.setAccessible(true);
                    Method declaredMethod = aClass.getDeclaredMethod("set" + sourceName.substring(0,1).toUpperCase() + sourceName.substring(1),type);
                    if(type.equals(String.class)){
                        declaredMethod.invoke(target,String.valueOf(entry.getValue()));
                    }else if(type.equals(Integer.class)){
                        declaredMethod.invoke(target,Integer.valueOf(String.valueOf(entry.getValue())));
                    }
                }
            }
        }
    }
}
