package alertmonitorsystem.service.impl;

import alertmonitorsystem.mapper.TestCaseMapper;
import alertmonitorsystem.service.ErrorTypeService;
import alertmonitorsystem.service.TestCaseService;
import alertmonitorsystem.utils.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuexu on 2019-07-25
 */
@Service
public class TestCaseServiceImpl implements TestCaseService {
    @Autowired
    private TestCaseMapper testCaseMapper;


    @Override
    @CachePut(cacheNames = "addTestCase")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int add(Map<String, Object> map) {
        int result = testCaseMapper.add(map);
//        System.out.println("id的类型是："+GetType.getType(CastUtil.cast(map.get("id"))));
        if(result > 0){
            int id = Integer.valueOf(CastUtil.cast(CastUtil.cast(map.get("id"))));
            return id;
        }
        return 0;
    }

    @Override
    @CacheEvict(cacheNames = "delTestCase",allEntries = true,beforeInvocation = true,condition = "#id>0")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int delete(Map<String, Object> map) {

        return testCaseMapper.delete(map);
    }

    @Override
    @CachePut(cacheNames = "updateTestCase",condition = "#id>0",unless = "#result>0")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int update(Map<String, Object> map) {
        return testCaseMapper.update(map);
    }

    @Override
    @CachePut(cacheNames = "testCase")
    public Map<String, Object> select(Map<String, Object> map) {

        List<Map<String, Object>> resultList = testCaseMapper.select(map);
        // 当前页
        map.put("code","200");

        map.put("status", "success");

        map.put("result", resultList);

        return map;
    }

    @Override
    @CachePut(cacheNames = "testCases")
    public Map<String, Object> likeSelect(Map<String, Object> map) {
        List<String> orderData = CastUtil.cast(map.get("orderData"));

        String orderStr = "";
        for (int i = 0; i < orderData.size(); i++) {
            if (i == orderData.size() - 1) {
                orderStr += orderData.get(i);
                break;
            }
            orderStr += orderData.get(i) + ",";
        }

        Integer currentPage = (Integer) map.get("currentPage");

        Integer start = (currentPage - 1) * 10;


        Integer totalPage = 1;

        // sql中的start
        map.put("start", start);
        // 每页显示10条
        map.put("pageSize", 10);


        //排序条件
        map.put("orderStr", orderStr);


        // 获取总个数
//        System.out.println("selectCount类型："+GetType.getType(testCaseMapper.likeSelectCount(map)));
        Integer totalCount = testCaseMapper.likeSelectCount(map);

        List<Map<String, Object>> resultList = testCaseMapper.likeSelect(map);

        if (totalCount != 0) {

            if (totalCount % 10 == 0) {
                totalPage = totalCount / 10;
            } else {
                totalPage = totalCount / 10 + 1;
            }

        }

        map.clear();
        // 当前页
        map.put("currentPage", currentPage);

        map.put("count", totalCount);

        map.put("totalPage", totalPage);

        map.put("result", resultList);

        return map;
    }

    @Override
    @Cacheable(cacheNames = "testCaseCount")
    public int likeSelectCount(Map<String, Object> map) {
        return testCaseMapper.likeSelectCount(map);
    }
}
