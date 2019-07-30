package alertmonitorsystem.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import alertmonitorsystem.mapper.ErrorTypeMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;



public class ExcelUtil {

	@SuppressWarnings("deprecation")
	public static CellStyle creatCellStyle(SXSSFWorkbook workbook) {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);// 右边框
		cellStyle.setWrapText(true);// 设置自动换行
		return cellStyle;
	}

	public static void exportExcel(HttpServletResponse response, ErrorTypeMapper dao, String[] headList,
								   String[] describeList) {
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);

		Map<String, Object> map = new HashMap<>();

		// 获取总个数
		Integer totalCount = dao.likeSelectCount(map);

		if (totalCount == 0) {
			ExcelUtil.export(response, workbook);
			return;
		}

		int totalPage = 0;

		int sheetCount = 0;
		// 分页查询 查询数据库的次数
		if (totalCount % 5000 == 0) {
			totalPage = totalCount / 5000;
		} else {
			totalPage = totalCount / 5000 + 1;
		}

		// sheet页的个数
		if (totalCount % 50000 == 0) {
			sheetCount = totalCount / 50000;
		} else {
			sheetCount = totalCount / 50000 + 1;
		}

		int k = 0;
		// 记录当前sql的开始页码
		int m = 0;
		// 记录总条数
		int n = 0;

		CellStyle cellStyle = ExcelUtil.creatCellStyle(workbook);

		for (int i = 0; i < sheetCount; i++) {

			Sheet sh = workbook.createSheet("sheet" + String.valueOf(i + 1));

			Row row = sh.createRow(0);
			// 设置表头
			for (int headIndex = 0; headIndex < headList.length; headIndex++) {
				sh.setColumnWidth(headIndex, 6000);
				Cell cell = row.createCell(headIndex);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(headList[headIndex]);
			}

			for (; m < totalPage; m++) {
				if ((k + 1) * 5000 > 50000) {
					// 重置k 退出当前循环
					k = 0;
					m--;
					break;
				}
				// 查询数据库的数据
				// sql中的start
				map.put("start", m * 5000);
				// 5000条
				map.put("pageSize", 5000);

				List<Map<String, Object>> resultList = dao.likeSelect(map);

				// 设置内容
				for (int resultIndex = 0; resultIndex < resultList.size(); resultIndex++) {

					Row currentRow = sh.createRow(n + 1);
					// 创建每个单元格
					for (int headIndex = 0; headIndex < headList.length; headIndex++) {
						Cell cell = currentRow.createCell(headIndex);
						cell.setCellStyle(cellStyle);
						String currentValue = String.valueOf(resultList.get(resultIndex).values().toArray()[headIndex]);
						// 获取当前字段的描述信息
						String describe = describeList[headIndex];

						// 必然是状态码
						if (describe.contains("#") && describe.contains("&")) {

							String[] arr = describe.split("#");

							Map<String, String> arrMap = new HashMap<>();

							for (String value : arr) {

								String[] statusArr = value.split("&");
								// 数据库中的值当作key，显示在Excel中的值当作value
								arrMap.put(statusArr[1], statusArr[0]);
							}
							cell.setCellValue(arrMap.get(currentValue));
							// 布尔类型
						} else if (describe.contains("#")) {

							String[] arr = describe.split("#");
							Map<String, String> arrMap = new HashMap<>();
							// 数据库中的值当作key，显示在Excel中的值当作value
							arrMap.put(arr[0], "是");
							arrMap.put(arr[1], "否");
							cell.setCellValue(arrMap.get(currentValue));
						} else {
							cell.setCellValue(currentValue);
						}
					}
					n++;
				}

				k++;
			}
		}

		export(response, workbook);
	}

	public static void export(HttpServletResponse response, SXSSFWorkbook workbook) {
		BufferedOutputStream out = null;
		String filename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "Datas.xlsx";
		// 设置文件名
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
			out = new BufferedOutputStream(response.getOutputStream());
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				// 处理在磁盘上备份此工作簿的临时文件
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
