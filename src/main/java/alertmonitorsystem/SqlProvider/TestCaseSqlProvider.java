package alertmonitorsystem.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-29
 */
public class TestCaseSqlProvider {

    /**
     *
     *  String sql = new SQL().SELECT("*")
     *                 .FROM("emp")
     *                 .WHERE("EMPNO LIKE '%" + param.get("empno") + "%'")
     *                 .AND()
     *                 .WHERE("ENAME LIKE '%" + param.get("ename") + "%'")
     *                 .toString();
     *         System.out.println("SQL" + sql);
     *         return sql;
     */

    public String select(Map<String, Object> map) {
        return new SQL() {{
            SELECT("*");
            FROM("test_case");
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
                .FROM("test_case")
                .ORDER_BY("id")
                .LIMIT("#{start},#{pageSize}")
                .toString();
        System.out.println("SQL " + sql);
        return sql;
    }


    public String insert(Map<String, Object> map) {
        String sql = new SQL().INSERT_INTO("test_case")
                .INTO_COLUMNS("id","department_name","test_case_name","test_result","last_test_result","last_result_time","assert_info","white_list_flag")
                .INTO_VALUES("#{id}","#{department_name}","#{test_case_name}","#{test_result}","#{last_test_result}","#{last_result_time}","#{assert_info}","#{white_list_flag}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }


    public String delete(Map<String, Object> map) {
        String sql = new SQL().DELETE_FROM("test_case")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    public String update(Map<String, Object> map) {
        String sql = new SQL().UPDATE("test_case")
                .SET("id = #{id}","department_name=#{department_name}","test_case_name=#{test_case_name}","test_result=#{test_result}",
                        "last_test_result=#{last_test_result}","last_result_time=#{last_result_time}","assert_info=#{assert_info}","white_list_flag=#{white_list_flag}")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"select count(1) from error_type"
    public String selectCount(Map<String, Object> map) {
        String sql = new SQL().SELECT("count(1)")
                .FROM("test_case")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }
}
