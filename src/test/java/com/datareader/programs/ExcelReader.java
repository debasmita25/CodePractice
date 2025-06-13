package com.datareader.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {

		readExcel();
	}

	public static void readExcel() {
		try {
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BMS_uploaded_ECG_tracker.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);

			Row firstRow = sheet.getRow(0);
			int totalRows = sheet.getLastRowNum() + 1;// total rows including label
			int totalColumns = firstRow.getLastCellNum();

			System.out.println(totalRows + " " + totalColumns);
			// to get the column labels only
			List<String> listLabels = new ArrayList<>();
			for (int i = 0; i < totalColumns; i++) {
				listLabels.add(firstRow.getCell(i).toString());
				// System.out.println(firstRow.getCell(i));
			}

			// System.out.println(listLabels);

			// Storing in Object 2D Array
			Object[][] data = new Object[totalRows - 1][1]; // 7
			// Map to store data
			Map<String, String> map = null;
			for (int i = 1; i < totalRows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < totalColumns; j++) {
					Cell cell = sheet.getRow(i).getCell(j);
					CellType cellType = cell.getCellType();
					String value = null;
					// System.out.println(cellType.name());
					switch (cellType.name()) {
					case "STRING":
						value = cell.getStringCellValue();
						break;
					case "NUMERIC":
						// Check if the cell contains a date
						if (DateUtil.isCellDateFormatted(cell)) {
							Date date = cell.getDateCellValue();
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
							value = dateFormat.format(date);

						} else {
							String temp = Double.toString(cell.getNumericCellValue());
							value = temp.substring(0, temp.indexOf("."));
						}
						break;
					case "BOOLEAN":
						value = Boolean.valueOf(cell.getBooleanCellValue()).toString();
					default:
						value = "not present";
					}
					;
					map.put(listLabels.get(j), value);
				}
				// System.out.println(i-1);
				data[i - 1][0] = map;
			}

			// Read Data
			System.out.println(Arrays.toString(data[0]));
			System.out.println(Arrays.toString(data[1]));
			System.out.println(Arrays.toString(data[2]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
