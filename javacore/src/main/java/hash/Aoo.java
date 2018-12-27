package hash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * Data 相当于拥有get set 重写了equals和hashcode
 *
 * @author qidi
 * @date 2018-12-27 13:40
 */
@Data
@AllArgsConstructor
//@EqualsAndHashCode(of = {"name", "id"})
public class Aoo {
    private String name;
    private Integer id;
}
