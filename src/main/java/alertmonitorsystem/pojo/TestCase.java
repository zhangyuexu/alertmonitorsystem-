package alertmonitorsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangyuexu on 2019-07-23
 */
public class TestCase implements Serializable {

    private static final long serialVersionUID = -819709867964586200L;
    private Integer id;
    private String departmentName;
    private String testCaseName;
    private String lastTestResult;
    private Date lastResultTime;
    private String assertInfo;
    private Boolean whiteListFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getLastTestResult() {
        return lastTestResult;
    }

    public void setLastTestResult(String lastTestResult) {
        this.lastTestResult = lastTestResult;
    }

    public Date getLastResultTime() {
        return lastResultTime;
    }

    public void setLastResultTime(Date lastResultTime) {
        this.lastResultTime = lastResultTime;
    }

    public String getAssertInfo() {
        return assertInfo;
    }

    public void setAssertInfo(String assertInfo) {
        this.assertInfo = assertInfo;
    }

    public Boolean getWhiteListFlag() {
        return whiteListFlag;
    }

    public void setWhiteListFlag(Boolean whiteListFlag) {
        this.whiteListFlag = whiteListFlag;
    }
}
