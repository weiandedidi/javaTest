package com.qidi.springthrift.service.impl;

import com.qidi.springthrift.api.UserService;
import com.qidi.springthrift.entry.UserRequest;
import com.qidi.springthrift.entry.UserResponse;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务接口实现
 *
 * @author: qidima
 * @date: 2018/5/3
 * Time: 11:35
 */
@Service
public class UserServiceImpl implements UserService.Iface {
    @Override
    public UserResponse userInfo(UserRequest request) throws TException {
        try {
            UserResponse urp = new UserResponse();
            if (request.id.equals("10000")) {
                urp.setCode("0");
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "lucy");
                urp.setParams(params);
            }
            System.out.println("接收参数是：id=" + request.id);
            return urp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
