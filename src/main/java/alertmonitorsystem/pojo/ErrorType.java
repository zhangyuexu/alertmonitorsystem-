package alertmonitorsystem.pojo;

import java.io.Serializable;

/**
 * Created by zhangyuexu on 2019-07-23
 */

public class ErrorType implements Serializable {

    private static final long serialVersionUID = -6914806017924241291L;
    private Integer id;
    private String errorType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}