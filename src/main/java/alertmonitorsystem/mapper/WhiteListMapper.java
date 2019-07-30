package alertmonitorsystem.mapper;

import alertmonitorsystem.SqlProvider.ErrorTypeSqlProvider;
import alertmonitorsystem.SqlProvider.WhiteListSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository

public interface WhiteListMapper {

    @InsertProvider(type = WhiteListSqlProvider.class,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Map<String, Object> map);

    @DeleteProvider(type = WhiteListSqlProvider.class,method = "delete")
    int delete(Map<String, Object> map);

    @UpdateProvider(type = WhiteListSqlProvider.class,method = "update")
    int update(Map<String, Object> map);

    @SelectProvider(type = WhiteListSqlProvider.class,method = "select")
    List<Map<String,Object>> select(Map<String, Object> map);

    @SelectProvider(type = WhiteListSqlProvider.class,method = "likeSelect")
    List<Map<String,Object>> likeSelect(Map<String, Object> map);

    @SelectProvider(type = WhiteListSqlProvider.class,method = "selectCount")
    int likeSelectCount(Map<String, Object> map);


}
