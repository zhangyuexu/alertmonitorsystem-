package alertmonitorsystem.pojo;

import java.io.Serializable;

/**
 * Created by zhangyuexu on 2019-07-23
 */
public class WhiteList implements Serializable {

    private static final long serialVersionUID = -3190002157069787015L;

    private Integer id;

    private String testCaseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }
}
