package wiley.automation.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelDataProvider {
	
	//static Logger log = Logger.getLogger(ReadExcelDataProvider.class);
	
	
	public static String[][] getExcelData(String fileName, String sheetName , String TestName) {
		String Active = "Y";
		String[][] arrayExcelData = null;
		int count = 0;
		int k = 0;
		try {
			
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty())
			{
			//Get the No. of Rows with Condition
			for (int x= 0 ; x < totalNoOfRows; x++) {
				
				if(SuiteUtil.TCList.contains(sh.getCell(0, x).getContents()) && sh.getCell(1, x).getContents().equalsIgnoreCase(Active))
				{
					if(sh.getCell(3, x).getContents().equalsIgnoreCase(TestName) && sh.getCell(1, x).getContents().equalsIgnoreCase(Active)){
						count++;
					}
				}
				
			}
			
			}
			
			
			arrayExcelData = new String[count][totalNoOfCols];
			if(null!=SuiteUtil.TCList && !SuiteUtil.TCList.isEmpty()){
			for (int i= 0 ; i < totalNoOfRows; i++) {
				if(SuiteUtil.TCList.contains(sh.getCell(0, i).getContents()) && sh.getCell(1, i).getContents().equalsIgnoreCase(Active))
				{
				if(sh.getCell(3, i).getContents().equalsIgnoreCase(TestName) && sh.getCell(1, i).getContents().equalsIgnoreCase(Active)){
				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[k][j] = sh.getCell(j, i).getContents().trim();
				} k++;
				}
				}
			}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}