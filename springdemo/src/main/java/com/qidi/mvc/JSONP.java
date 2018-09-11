package com.qidi.mvc;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 跨域
 * 返回jsonp  和spring 4.1之前和之后
 *
 * @author: qidima
 * @date: 2018/7/3
 * Time: 20:40
 */
@Controller("jsonp")
public class JSONP {

    /**
     * spring 4.1 在之后 使用MappingJacksonValue jsonp实现跨域
     * 此方法兼容json
     *
     * @return
     */
    @RequestMapping("/result")
    @ResponseBody
    public Object commentById(@RequestParam(value = "id") Integer id, @RequestParam(value = "callback", required = false) String callback) {
        String result = "data";
        if (null != callback) {
            //返回jsonp
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        //返回json
        return result;
    }


    /**
     * 使用@CrossOrigin注解实现跨域，可标注在类和方法上
     *
     * @param id
     * @param callback
     * @return
     */
    @RequestMapping("/resultV2")
    @ResponseBody
    @CrossOrigin
    public Object commentByIdV2(@RequestParam(value = "id") Integer id) {
        String result = "data";
        //返回json
        return result;
    }

}
