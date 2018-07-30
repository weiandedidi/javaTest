package json;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/23
 * Time: 17:47
 */
public class Ao implements Serializable {
    private Integer id;
    private Data data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
