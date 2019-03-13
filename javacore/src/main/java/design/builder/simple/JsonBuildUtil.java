package design.builder.simple;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.URL;
import java.util.Map;

/**
 * 配置json操作工具类
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/30
 * Time: 17:16
 */
public class JsonBuildUtil {
    //根据传入建造的类型返回具体实例
    public  static Object getBean(String className) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //读取新闻json配置请求
        String filePath = "D:\\work\\javaTest\\wms\\src\\main\\java\\design\\builder\\simple\\config.json";
        Map<String, Object> jsonMap = null;
        String jsonString = BufferedReaderDemo(filePath);
        jsonMap = (Map<String, Object>) JSON.parse(jsonString);
        String name = (String) jsonMap.get(className);
        //实例化
        ActorBuilder actorBuilder = null;
        Class c = Class.forName(name);
        if (null != c) {
            actorBuilder = (ActorBuilder) c.newInstance();
        }
        return actorBuilder;
    }

    /**
     * 读文件
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static String BufferedReaderDemo(String path) throws IOException {
        File file = new File(path);
        if (!file.exists() || file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = null;
        StringBuffer sb = new StringBuffer();
        temp = br.readLine();
        while (temp != null) {
            sb.append(temp + " ");
            temp = br.readLine();
        }
        return sb.toString();
    }

}
