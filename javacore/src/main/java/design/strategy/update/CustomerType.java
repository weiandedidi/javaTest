package design.strategy.update;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qidi
 * @date 2019-03-13 17:38
 */
public enum CustomerType {

    STUDENT(Student.class, new StudentStrategy()),
    VIP(VIP.class, new VIPStrategy()),
    CHILD(Child.class, new ChildStrategy());

    private Class classType;
    private CustomerStrategy customerStrategy;

    CustomerType(Class type, CustomerStrategy customerStrategy) {
        this.classType = type;
        this.customerStrategy = customerStrategy;
    }

    private static Map<Class, CustomerType> map = new HashMap<>();

    static {
        for (CustomerType customerType : CustomerType.values()) {
            map.put(customerType.getClassType(), customerType);
        }
    }

    public Class getClassType() {
        return classType;
    }

    public CustomerStrategy getCustomerStrategy() {
        return customerStrategy;
    }

    public static CustomerType getInstance(Class classType) {
        return map.get(classType);
    }
}
