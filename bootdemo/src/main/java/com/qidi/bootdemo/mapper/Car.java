package com.qidi.bootdemo.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qidi
 * @date 2019-01-31 16:28
 */
@Data
@AllArgsConstructor
public class Car {
    /**
     * 车型
     */
    private String model;
    /**
     * 商标
     */
    private String brand;
}
