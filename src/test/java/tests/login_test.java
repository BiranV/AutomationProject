package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.login;
import pageobjects.inventory;
import utilities.DataProviders;

public class login_test extends base_test {
	
	@Test(dataProvider = "getFromExcel", dataProviderClass = DataProviders.class, description = "data from excel")
	public void t01_loginFromExcelData(String user, String password) throws InterruptedException {
		login lp = new login(driver);
		lp.login(user, password);
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(dataProvider = "getData", dataProviderClass = DataProviders.class, description = "data from table information")
	public void t02_loginFailedFromTable(String user, String password) throws InterruptedException {
		login lp = new login(driver);
		lp.login(user, password);
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(description = "Login with wrong password and match assert")
	public void t03_loginFailedMatchAssert() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secretsauce"); // wrong password
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(description = "Login with right username and password")
	public void t05_loginSucceed() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secret_sauce");
		inventory in = new inventory(driver);
		String actualMsg = in.loginSuccess();
		assertEquals(actualMsg, "Products");
	}
	
}
