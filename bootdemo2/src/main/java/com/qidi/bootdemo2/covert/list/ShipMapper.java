package com.qidi.bootdemo2.covert.list;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 嵌套的转换，如list形，必须每一对象进行对应
 * 如：Passenger->Customer  才能List<Passenger> -> List<Customer>
 *
 * @author qidi
 * @date 2019-02-01 13:53
 */
@Mapper(componentModel = "spring")
public interface ShipMapper {

    ShipMapper INSTANCE = Mappers.getMapper(ShipMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "title"),
            @Mapping(source = "age", target = "year")
    })
    ShipDto.Customer covertToCustomer(Ship.Passenger passenger);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "passengerList", target = "customers")
    })
    ShipDto convertToShipDto(Ship ship);


}
