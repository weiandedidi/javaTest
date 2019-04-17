package annotation;

import java.awt.event.ActionListener;
import java.lang.annotation.*;

/**
 * @author qidi
 * @date 2019-04-17 16:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)  //定义作用在字段上
@Documented
public @interface ActionListenerAnno {
    //该listener成员变量用于保存监听器实现类
    Class<? extends ActionListener> listener();
}
