package practicemaven.Mavanjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("D:\\Document\\Selenium Stuff\\Data Files\\DemoData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		//XSSFSheet sheet = workbook.getSheet("testdata");
		//Iterator<Row> rows = sheet.iterator();// Sheet is collection of row and Iterate the Row
		//Row firstRow = rows.next();
		System.out.println("Total Sheets count: "+sheets);

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();// Sheet is collection of row and Iterate the Row
				Row firstRow = rows.next();
				Iterator<Cell> cl = firstRow.cellIterator();// Row is collection of cells and Iterate the Cells
				int k = 0;
				int column = 0;
				while (cl.hasNext()) {
					Cell value = cl.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							//System.out.println(cv.next().getStringCellValue());
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
								System.out.print(c.getStringCellValue()+" | ");
								
							}
							else
							{
								System.out.print(c.getNumericCellValue()+" | ");
							}
						}System.out.println();
					}
				}
			}
		}
	}

}
