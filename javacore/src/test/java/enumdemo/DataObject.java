package enumdemo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/8/16
 * Time: 9:44
 */
public enum DataObject {
    /**
     * 实力
     */
    INSTANCE;

    private static ArrayList<Integer> indexs = new ArrayList<Integer>();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    public ArrayList<Integer> getIndexs() {
        return indexs;
    }

    public void setIndexs(ArrayList<Integer> indexs) {
        DataObject.indexs = indexs;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        DataObject.map = map;
    }
}
