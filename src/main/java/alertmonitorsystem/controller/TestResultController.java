package alertmonitorsystem.controller;

import alertmonitorsystem.service.TestCaseService;
import alertmonitorsystem.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test_result")
public class TestResultController {

	@Autowired
	private TestResultService service;

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping("/select")
	public Map<String, Object> select(@RequestBody Map<String, Object> map) {
		return service.select(map);
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	@RequestMapping("/likeSelect")
	public Map<String, Object> likeSelect(@RequestBody Map<String, Object> map) {
		return service.likeSelect(map);
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@RequestMapping("/update")
	public void update(@RequestBody Map<String, Object> map) {
		service.update(map);
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public void add(@RequestBody Map<String, Object> map) {
		service.add(map);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping("/delete")
	public void delete(@RequestBody Map<String, Object> map) {
		service.delete(map);
	}

}
