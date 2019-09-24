package com.wdg.entity;

import java.time.LocalDateTime;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Builder
@Document(collection = "pm_raw_data_column")
@Data
@AllArgsConstructor
public class RawDataColumn<T>{

    @Id
    private T id;
    /**
     * 创建时间
     */
    @Field(value="create_time")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Field(value="update_time")
    private LocalDateTime updateTime;
    /**
     * 字段对应的表单KEY
     * 同一个operation下，具有唯一性
     */
    @Field(value = "form_key")
    private String formKey;

    /**
     * 字段名称
     * excel表头
     * 同一个operation下，具有唯一性
     */
    @Field(value = "name")
    private String name;

    /**
     * 字段描述
     */
    @Field(value = "desc")
    private String desc;

    /**
     * 运营组
     */
    @Field(value = "operation")
    private String operation;

    /**
     * INPUT("input"),//单行输入框
     * MULTIPLEINPUT("multipleInput"),//多行输入框
     * SELECT("select"),//单选下拉选框
     * MULTIPLESELECT("multipleSelect"),//多选下拉选框
     * DATETIMERANGE("dateTimeRange");//日期时间范围选择框
     */
    @Field(value = "type")
    private String type;

    /**
     * 当type为选项框时，这里为选项集合
     * 否则为null
     */
    @Field(value = "options")
    private HashMap<Object, String> options;

    /**
     * 显示列
     */
    @Field(value = "toggle")
    private Boolean toggle;

    /**
     * 排序
     */
    @Field(value = "order")
    private Integer order;

    /**
     * 是否为主键字段
     */
    @Field(value = "primary_key")
    private Boolean primaryKey = false;

    /**
     * 是否为系统字段
     */
    @Field(value = "system_field")
    private Boolean systemField = false;

    @Field(value = "no_blank")
    private Boolean noBlank;

}
