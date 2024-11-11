package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelDataProvider {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;

	// Open the Excel file and select the sheet
	public static void openExcel(String path, String sheetName) throws FileNotFoundException, IOException {

		FileInputStream excelSheet = new FileInputStream(path);
		workbook = new XSSFWorkbook(excelSheet);
		sheet = workbook.getSheet(sheetName);
	}

	// Get row count of the sheet
	public static int getRowCount() {

		return sheet.getLastRowNum();
	}

	// Get column count of the first row
	public static int getColCount() {

		return sheet.getRow(0).getLastCellNum();

	}

	// Get data from the sheet
	public static Object[][] getSheetData() {

		int rows = getRowCount();
		int cols = getColCount();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			
			XSSFRow row = sheet.getRow(i + 1);
			
			for (int j = 0; j < cols; j++) {
				
				cell = row.getCell(j);

				if (cell.getCellType().equals(CellType.STRING)) {
					data[i][j] = cell.getStringCellValue();
				} else if (cell.getCellType().equals(CellType.NUMERIC)) {
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
				}

			}

		}
		return data;

	}

}