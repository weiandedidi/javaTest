package com.qidi.bootdemo2.covert.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qidi
 * @date 2019-02-01 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipDto {
    /**
     * id
     */
    private int id;
    /**
     * 乘客们
     */
    private List<Customer> customers;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Customer {
        /**
         * 名衔
         */
        private String title;
        /**
         * 岁数
         */
        private int year;
    }
}
