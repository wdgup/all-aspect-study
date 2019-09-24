package com.wdg.service.impl;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.MongoDatabase;
import com.wdg.entity.JDCategory;
import com.wdg.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * User: wangdaogang
 * Date: 2019/9/24
 * Description: No Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TmallCategoryServiceImplTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void one(){
        String outputPath = "C:\\Users\\jm005227\\Desktop\\类目映射\\guess\\Tmall\\1.xlsx";
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("shopId").is("guess");
        query.addCriteria(criteria);
        List<JSONObject> jsonObjects = mongoTemplate.find(query, JSONObject.class, "TmallShopCategory");
        System.out.println(jsonObjects);
        List<Product> collect = jsonObjects.stream().map(obj -> {
            List<String> str = (List<String>) obj.get("namePath");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.size(); i++) {
                if (i != str.size() - 1) {
                    sb.append(str.get(i) + ">>");
                } else {
                    sb.append(str.get(i));
                }
            }
            return Product.builder().cid(obj.get("cid").toString()).name(obj.get("name").toString()).namePath(sb.toString()).build();

        }).collect(Collectors.toList());
        try {
            OutputStream outputStream = new FileOutputStream(outputPath);
            ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
            Sheet sheet = new Sheet(1,0,Product.class);
            sheet.setSheetName("tmall 类目");
            writer.write(collect,sheet);
            writer.finish();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    @Test
    public void two(){
        MongoDatabase db = mongoTemplate.getDb();
        System.out.println(db);
        String outputPath = "C:\\Users\\jm005227\\Desktop\\类目映射\\gap\\JD\\1.xlsx";
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("shopId").is(103760);
        query.addCriteria(criteria);
        List<JSONObject> jsonObjects = mongoTemplate.find(query, JSONObject.class, "category_new");
        System.out.println(jsonObjects);
        List<JDCategory> collect = jsonObjects.stream().filter(a->StringUtils.isNoneBlank(a.getString("categoryPath"))).map(obj -> {
             return JDCategory.builder().fid(obj.get("fid").toString())
                    .id(obj.getString("id"))
                    .categoryPath(obj.getString("categoryPath"))
                    .lev(obj.getInteger("lev"))
                    .name(obj.getString("name"))
                    .build();
        }).collect(Collectors.toList());
        try {
            OutputStream outputStream = new FileOutputStream(outputPath);
            ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
            Sheet sheet = new Sheet(1,0,JDCategory.class);
            sheet.setSheetName("JD类目");
            writer.write(collect,sheet);
            writer.finish();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
