package com.wdg.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseRowModel implements Serializable {
    @ExcelProperty(value = "cid",index = 0)
    private String cid;
    @ExcelProperty(value = "name",index = 1)
    private String name;
    @ExcelProperty(value = "namePath",index = 2)
    private String namePath;
}
