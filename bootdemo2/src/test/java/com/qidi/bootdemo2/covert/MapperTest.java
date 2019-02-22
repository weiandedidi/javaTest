package com.qidi.bootdemo2.covert;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author qidi
 * @date 2019-01-31 18:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    CarMapper carMapper;

    @Test
    public void testMapper() {
        Car car = new Car("3系", "宝马");
        CarDto carDto = carMapper.carToCarDto(car);
        System.out.println(carDto.getBrandDto());
    }


    @Test
    public void testListMapper() {
        Car car = new Car("3系", "宝马");

        List<CarDto> carDtos = carMapper.carsToCarDtoList(
                Lists.newArrayList(
                        new Car("3系", "宝马1"),
                        new Car("2系", "宝马2"))
        );
        System.out.println(carDtos.get(0).getBrandDto());
    }
}
