package alertmonitorsystem.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-29
 */
public class TestResultSqlProvider {

    public String select(Map<String, Object> map) {
        return new SQL() {{
            SELECT("*");
            FROM("test_result");
            if (map.get("id") != "" && map.get("id") != null) {
                WHERE("id=#{id}");
            }
            if (map.get("test_case_name") != "" && map.get("test_case_name") != null) {
                WHERE("test_case_name=#{test_case_name}");
            }
        }}.toString();
    }

//    public String select(Map<String, Object> map) {
//        String sql = new SQL().SELECT("*")
//                .FROM("error_type")
//                .WHERE("id=#{id}","error_type=#{error_type}")
//                .toString();
//        System.out.println("SQL: " + sql);
//        return sql;
//    }

    public String likeSelect(Map<String, Object> map) {
        String sql = new SQL().SELECT("*")
                .FROM("test_result")
                .ORDER_BY("id")
                .LIMIT("#{start},#{pageSize}")
                .toString();
        System.out.println("SQL " + sql);
        return sql;
    }


    public String insert(Map<String, Object> map) {
        String sql = new SQL().INSERT_INTO("test_result")
                .INTO_COLUMNS("id","department_name","test_case_name","test_result","assert_info","testplan_time","error_type","error_comments","testresult_time")
                .INTO_VALUES("#{id}","#{department_name}","#{test_case_name}","#{test_result}","#{assert_info}","#{testplan_time}","#{error_type}",
                        "#{error_comments}","#{testresult_time}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }


    public String delete(Map<String, Object> map) {
        String sql = new SQL().DELETE_FROM("test_result")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    public String update(Map<String, Object> map) {
        String sql = new SQL().UPDATE("test_result")
                .SET("id = #{id}","department_name=#{department_name}","test_case_name=#{test_case_name}","test_result=#{test_result}",
                        "assert_info=#{assert_info}","testplan_time=#{testplan_time}","error_type=#{error_type}","error_comments=#{error_comments}","testresult_time=#{testresult_time}")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }


    public String selectCount(Map<String, Object> map) {
        String sql = new SQL().SELECT("count(1)")
                .FROM("test_result")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }
}
