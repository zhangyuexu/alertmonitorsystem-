package alertmonitorsystem.service;

import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-25
 */
public interface WhiteListService {


    int add(Map<String, Object> map);


    int delete(Map<String, Object> map);


    int update(Map<String, Object> map);


    Map<String,Object> select(Map<String, Object> map);


    Map<String, Object> likeSelect(Map<String, Object> map);


    int likeSelectCount(Map<String, Object> map);
}
