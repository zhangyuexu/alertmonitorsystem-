package alertmonitorsystem.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-29
 */
public class WhiteListSqlProvider {

    public String select(Map<String, Object> map) {
        return new SQL() {{
            SELECT("*");
            FROM("white_list");
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

    //"select id, error_type from error_type order by id limit #{start},#{pageSize}"
    public String likeSelect(Map<String, Object> map) {
        String sql = new SQL().SELECT("*")
                .FROM("white_list")
                .ORDER_BY("id")
                .LIMIT("#{start},#{pageSize}")
                .toString();
        System.out.println("SQL " + sql);
        return sql;
    }

    //"insert into error_type(id,error_type)VALUES(#{id},#{error_type})"
    public String insert(Map<String, Object> map) {
        String sql = new SQL().INSERT_INTO("white_list")
                .INTO_COLUMNS("id","test_case_name")
                .INTO_VALUES("#{id}","#{test_case_name}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"delete from error_type where id = #{id}"
    public String delete(Map<String, Object> map) {
        String sql = new SQL().DELETE_FROM("white_list")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"update error_type set id = #{id},error_type = #{error_type} where id = #{id}"
    public String update(Map<String, Object> map) {
        String sql = new SQL().UPDATE("white_list")
                .SET("id = #{id}","test_case_name = #{test_case_name}")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"select count(1) from error_type"
    public String selectCount(Map<String, Object> map) {
        String sql = new SQL().SELECT("count(1)")
                .FROM("white_list")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }
}
