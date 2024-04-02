package Fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static  String readCellData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/cotivityLoginData.xlsx");
//		
//		Workbook book=WorkbookFactory.create(fis);
//		
//		Sheet sheet =book.getSheet("login");
//		
//		Row row=sheet.getRow(1);
//		
//		Cell cell=row.getCell(1);
//		
//		System.out.println(cell);
		
		return WorkbookFactory.create(fis).getSheet("login").getRow(3).getCell(1).toString();
	}
	
	
	
	public static String[][] readRowData(String sheetname) throws Exception, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/cotivityLoginData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet =book.getSheet(sheetname);
		
		int row=sheet.getPhysicalNumberOfRows();
		
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[row-1][col];
		
		for(int i=1;i<row;i++) {
			for(int j=0;j<col;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				 
			}
			System.out.println();
		}
		
		return data;
		
	}
	
	
}
