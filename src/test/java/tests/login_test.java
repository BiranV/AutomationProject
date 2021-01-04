package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.login;
import pageobjects.inventory;
import utilities.DataProviders;

public class login_test extends base_test {

	@Test(dataProvider = "getData", dataProviderClass = DataProviders.class, description = "use from table information")
	public void t01_loginFailedFromTable(String user, String password) throws InterruptedException {
		login lp = new login(driver);
		lp.login(user, password);
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(description = "Login with wrong password and match assert")
	public void t02_loginFailedMatchAssert() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secretsauce"); // wrong password
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service"); // match
	}

	@Test(description = "Login with wrong password with unmatch assert")
	public void t03_loginFailedNoMatchAssert() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secretsauce"); // wrong password
		String expected = "Sorry! Epic sadface: Username and password do not match any user in this service";
		String actualMsg = lp.errorMsg();
		assertEquals(actualMsg, expected); // no match
	}

	@Test(description = "Login with right username and password")
	public void t04_loginSucceed() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secret_sauce");
		inventory in = new inventory(driver);
		String actualMsg = in.loginSuccess();
		assertEquals(actualMsg, "Products");
	}
	
}
