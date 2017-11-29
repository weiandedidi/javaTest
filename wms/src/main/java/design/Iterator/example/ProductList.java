package design.Iterator.example;

import java.util.List;

/**
 * 商品数据类：具体聚合类
 *
 * @author: qidima
 * @date: 2017/11/29
 * Time: 16:56
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List objects) {
        super(objects);
    }

    @Override
    public AbstractIterator iterator() {
        //如果需要为ProductList类更换一个迭代器”，此处可以传入固定参数，类反射，实例化不同的迭代器
        return new ProductIterator(this);
    }
}
