package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "getData")
	public Object[][] getData() {
		Object[][] myData = { { "biranvaron", "12345" }, { "varonbiran", "54321" }, { "username", "password1541" },
				{ "userBiran", "mycode88" } };
		return myData;
	}
	
	@DataProvider(name = "getFromExcel")
	public Object[][] getFromExcel() {
		
		String excelPath = "./data/TestData.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		
		Object[][] myData = { 
				{ excel.getCellData(1,0), excel.getCellData(1,1) },
				{ excel.getCellData(2,0), excel.getCellData(2,1) },
				{ excel.getCellData(3,0), excel.getCellData(3,1) },
				};
		
		return myData;
		
	}
}
