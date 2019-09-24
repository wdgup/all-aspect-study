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
public class JDCategory extends BaseRowModel implements Serializable {
    @ExcelProperty(value = "fid",index = 0)
    private String fid;
    @ExcelProperty(value = "id",index = 1)
    private String id;
    @ExcelProperty(value = "lev",index = 2)
    private Integer lev;
    @ExcelProperty(value = "name",index = 3)
    private String name;
    @ExcelProperty(value = "categoryPath",index = 4)
    private String categoryPath;
}
