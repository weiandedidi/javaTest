[TOC]

# MapStruct

## 定义

`MapStruct`是一种类型安全的`bean映射`类生成java注释处理器。

## 应用场景

业务代码中类型的转化，比如传输类dto转为服务应用对象model。

### 使用

#### 1.pom设置

集成`springboot|spring`

```xml
<dependencies>
<!--mapper类的转换工具-->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.2.0.Final</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.2.0.Final</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### 2.代码

将==Car -> CarDto== ，源属性`source`，目标属性`target`

```java
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mappings({
            @Mapping(source = "model", target = "modelDto"),
            @Mapping(source = "brand", target = "brandDto")
    })
    public CarDto carToCarDto(Car car);

}
```