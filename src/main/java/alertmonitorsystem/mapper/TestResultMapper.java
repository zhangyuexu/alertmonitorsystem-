package alertmonitorsystem.mapper;

import alertmonitorsystem.SqlProvider.TestResultSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository

public interface TestResultMapper {

//    @Insert("insert into test_result(id,department_name,test_case_name,test_result,assert_info,testplan_time,error_type,error_comments,testresult_time)" +
//            "values(#{id},#{department_name},#{test_case_name},#{test_result},#{assert_info},#{testplan_time},#{error_type},#{error_comments},#{testresult_time})")
    @InsertProvider(type = TestResultSqlProvider.class,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Map<String, Object> map);

//    @Delete("delete from test_result where id = #{id}")
    @DeleteProvider(type = TestResultSqlProvider.class,method = "delete")
    int delete(Map<String, Object> map);

//    @Update("update test_result set id = #{id},department_name=#{department_name},test_case_name=#{test_case_name},test_result=#{test_result}," +
//            "assert_info=#{assert_info},testplan_time=#{testplan_time},error_type=#{error_type}," +
//            "error_comments=#{error_comments},testresult_time=#{testresult_time} where id = #{id}")
    @UpdateProvider(type = TestResultSqlProvider.class,method = "update")
    int update(Map<String, Object> map);

//    @Select("select * from test_result where id = #{id} order by id")
    @SelectProvider(type = TestResultSqlProvider.class,method = "select")
    List<Map<String,Object>> select(Map<String, Object> map);

//    @Select("select * from test_result order by id limit #{start},#{pageSize}")
    @SelectProvider(type = TestResultSqlProvider.class,method = "likeSelect")
    List<Map<String,Object>> likeSelect(Map<String, Object> map);

//    @Select("select count(1) from test_result")
    @SelectProvider(type = TestResultSqlProvider.class,method = "selectCount")
    int likeSelectCount(Map<String, Object> map);


}
