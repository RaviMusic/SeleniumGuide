package readData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RetrieveTestData {

	// Map Interface in Java
	public static void mapUsage() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("01", "Suresh");

		map.put("02", "Ravi");

		map.put("03", "Sruthi");

		map.put("UserName", "admin");

		map.put("Password", "admin");

		System.out.println(map.get("02"));
	}

	public static Map<String, String> readData(String sheetName, String testCaseName) {
		
		Map<String, String> map = null;
		try {

			map = new HashMap<String, String>();

			File filePath = new File("./ExcelData/TestData.xlsx");

			FileInputStream fin = new FileInputStream(filePath);

			XSSFWorkbook wb = new XSSFWorkbook(fin);

			XSSFSheet sh = wb.getSheet(sheetName);

			int rows = sh.getLastRowNum() - sh.getFirstRowNum();

			System.out.println("Total No.of Rows :" + rows);

			int cols = sh.getRow(0).getLastCellNum();

			System.out.println("Total No.of Columns " + cols);

			for (int i = 1; i <= rows; i++) {

				String testName = sh.getRow(i).getCell(0).getStringCellValue();

				if (testCaseName.equalsIgnoreCase(testName)) {

					for (int j = 1; j < cols; j++) {

						String key = sh.getRow(0).getCell(j).getStringCellValue();

						String value = sh.getRow(i).getCell(j).getStringCellValue();

						map.put(key, value);
					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {

		readData("HMS", "ERegistration");
	}
}
