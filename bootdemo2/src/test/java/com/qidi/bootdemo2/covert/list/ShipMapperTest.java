package com.qidi.bootdemo2.covert.list;


import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qidi
 * @date 2019-02-01 13:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipMapperTest {

    @Autowired
    ShipMapper shipMapper;

    @Test
    public void testCovert() {
        Ship ship = new Ship(12, Lists.newArrayList(new Ship.Passenger("我是一", 12), new Ship.Passenger("我是二", 12)));

        ShipDto shipDto = shipMapper.convertToShipDto(ship);
        System.out.println(shipDto.getCustomers().get(0).getTitle());
    }

}