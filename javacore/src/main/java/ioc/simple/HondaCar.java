package ioc.simple;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 本田汽车
 *
 * @author qidi
 * @date 2019-03-01 16:55
 */
@AllArgsConstructor
@NoArgsConstructor
public class HondaCar implements Car {
    private String name;

    @Override
    public void printBrand() {
        System.out.println("我是 " + this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
