package alertmonitorsystem.mapper;

import alertmonitorsystem.SqlProvider.ErrorTypeSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository

public interface ErrorTypeMapper {

//    @Insert("insert into error_type(id,error_type)VALUES(#{id},#{error_type})")
    @InsertProvider(type = ErrorTypeSqlProvider.class,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Map<String, Object> map);

//    @Delete("delete from error_type where id = #{id}")
    @DeleteProvider(type = ErrorTypeSqlProvider.class,method = "delete")
    int delete(Map<String, Object> map);

//    @Update("update error_type set id = #{id},error_type = #{error_type} where id = #{id}")
    @UpdateProvider(type = ErrorTypeSqlProvider.class,method = "update")
    int update(Map<String, Object> map);

//    @Select("select id, error_type from error_type where id = #{id} order by id")
    @SelectProvider(type = ErrorTypeSqlProvider.class,method = "select")
    List<Map<String,Object>> select(Map<String, Object> map);

//    @Select("select id, error_type from error_type order by id limit #{start},#{pageSize}")
    @SelectProvider(type = ErrorTypeSqlProvider.class,method = "likeSelect")
    List<Map<String,Object>> likeSelect(Map<String, Object> map);

//    @Select("select count(1) from error_type")
    @SelectProvider(type = ErrorTypeSqlProvider.class,method = "selectCount")
    int likeSelectCount(Map<String, Object> map);


}
