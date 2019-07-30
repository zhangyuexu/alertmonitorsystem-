package alertmonitorsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangyuexu on 2019-07-23
 */
public class TestResult implements Serializable {

    private static final long serialVersionUID = -91463931106114605L;
    private Integer id;
    private String departmentName;
    private String testCaseName;
    private String testResult;
    private String assertInfo;
    private Date testPlanTime;
    private String errorType;
    private String errorComments;
    private Date testResultTime;

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

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getAssertInfo() {
        return assertInfo;
    }

    public void setAssertInfo(String assertInfo) {
        this.assertInfo = assertInfo;
    }

    public Date getTestPlanTime() {
        return testPlanTime;
    }

    public void setTestPlanTime(Date testPlanTime) {
        this.testPlanTime = testPlanTime;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorComments() {
        return errorComments;
    }

    public void setErrorComments(String errorComments) {
        this.errorComments = errorComments;
    }

    public Date getTestResultTime() {
        return testResultTime;
    }

    public void setTestResultTime(Date testResultTime) {
        this.testResultTime = testResultTime;
    }
}
