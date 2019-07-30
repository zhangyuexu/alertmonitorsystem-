package alertmonitorsystem.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-29
 */
public class ErrorTypeSqlProvider {

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
            FROM("error_type");
            if (map.get("id") != "" && map.get("id") != null) {
                WHERE("id=#{id}");
            }
            if (map.get("error_type") != "" && map.get("error_type") != null) {
                WHERE("error_type=#{error_type}");
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
                .FROM("error_type")
                .ORDER_BY("id")
                .LIMIT("#{start},#{pageSize}")
                .toString();
        System.out.println("SQL " + sql);
        return sql;
    }

    //"insert into error_type(id,error_type)VALUES(#{id},#{error_type})"
    public String insert(Map<String, Object> map) {
        String sql = new SQL().INSERT_INTO("error_type")
                .INTO_COLUMNS("id","error_type")
                .INTO_VALUES("#{id}","#{error_type}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"delete from error_type where id = #{id}"
    public String delete(Map<String, Object> map) {
        String sql = new SQL().DELETE_FROM("error_type")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"update error_type set id = #{id},error_type = #{error_type} where id = #{id}"
    public String update(Map<String, Object> map) {
        String sql = new SQL().UPDATE("error_type")
                .SET("id = #{id}","error_type = #{error_type}")
                .WHERE("id = #{id}")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }

    //"select count(1) from error_type"
    public String selectCount(Map<String, Object> map) {
        String sql = new SQL().SELECT("count(1)")
                .FROM("error_type")
                .toString();

        System.out.println("SQL " + sql);
        return sql;
    }
}
