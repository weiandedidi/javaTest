package design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1. proxy类实现InvocationHandler
 * 2. proxy类 成员变量是 被代理类的接口
 * 3. 重写 nvoke(Object proxy, Method method, Object[] args)接口，method.invoke(subject, args)方法前后做一些活是可以的。
 *
 * @author: qidima
 * @date: 2018/5/14
 * Time: 10:13
 */
public class DynamicProxy implements InvocationHandler {

    //　这个就是我们要代理的真实对象
    private Object subject;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object target = method.invoke(subject, args);
        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return target;
    }
}
