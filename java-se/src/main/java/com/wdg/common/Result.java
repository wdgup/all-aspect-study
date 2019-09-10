package com.wdg.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: wangdaogang
 * Date: 2019/9/10
 * Description: No Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;
}
