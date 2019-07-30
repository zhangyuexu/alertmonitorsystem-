package alertmonitorsystem.mapper;

import alertmonitorsystem.SqlProvider.TestCaseSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository

public interface TestCaseMapper {

//    @Insert("insert into Test_case(id,department_name,test_case_name,test_result,last_test_result,last_result_time," +
//            "assert_info,white_list_flag)VALUES(#{id},#{department_name},#{test_case_name},#{test_result},#{last_test_result}," +
//            "#{last_result_time,jdbcType=DATE},#{assert_info},#{white_list_flag})")
    @InsertProvider(type = TestCaseSqlProvider.class,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Map<String, Object> map);

//    @Delete("delete from Test_case where id = #{id}")
    @DeleteProvider(type = TestCaseSqlProvider.class,method = "delete")
    int delete(Map<String, Object> map);

//    @Update("update Test_case set id = #{id},department_name=#{department_name},test_case_name=#{test_case_name},test_result=#{test_result}," +
//            "last_test_result=#{last_test_result},last_result_time=#{last_result_time},assert_info=#{assert_info}," +
//            "white_list_flag=#{white_list_flag} where id = #{id}")
    @UpdateProvider(type = TestCaseSqlProvider.class,method = "update")
    int update(Map<String, Object> map);

//    @Select("select * from Test_case where id = #{id} order by id")
    @SelectProvider(type = TestCaseSqlProvider.class,method = "select")
    List<Map<String,Object>> select(Map<String, Object> map);

//    @Select("select * from Test_case order by id limit #{start},#{pageSize}")
    @SelectProvider(type = TestCaseSqlProvider.class,method = "likeSelect")
    List<Map<String,Object>> likeSelect(Map<String, Object> map);

//    @Select("select count(1) from Test_case")
    @SelectProvider(type = TestCaseSqlProvider.class,method = "selectCount")
    int likeSelectCount(Map<String, Object> map);


}
