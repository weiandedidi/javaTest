package zookeeperConfig;

import lombok.*;

import java.io.Serializable;

/**
 * zookeeper的动态配置
 *
 * @author qidi
 * @date 2018-12-19 20:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;

}
