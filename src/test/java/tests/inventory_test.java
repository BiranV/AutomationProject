package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageobjects.inventory;
import pageobjects.login;
import pageobjects.cart;

public class inventory_test extends base_test {

	@Test
	public void t01_loginSucceed() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secret_sauce");
		inventory in = new inventory(driver);
		String actualMsg = in.loginSuccess();
		assertEquals(actualMsg, "Products");
		Thread.sleep(1000);
	}

	@Test
	public void t02_addOneItemAndBack() {
		inventory item = new inventory(driver);
		item.nameOfItem();
		item.addToCart();
		item.back();
		inventory in = new inventory(driver);
		String actualMsg = in.loginSuccess();
		assertEquals(actualMsg, "Products");
	}

	@Test
	public void t03_addListItems() {
		inventory item = new inventory(driver);
		item.chooseToItemsList("Sauce Labs Bike Light");
		item.chooseToItemsList("Test.allTheThings() T-Shirt (Red)");
		item.chooseToItemsList("Sauce Labs Bolt T-Shirt");
		item.chooseToItemsList("Sauce Labs Onesie");
		cart ca = new cart(driver);
		String actualMsg = ca.valueOfItems();
		assertEquals(actualMsg, "5");
	}

	@Test
	public void t04_lowToHigh() {
		inventory item1 = new inventory(driver);
		String actualMsg = item1.sortLowToHigh();
		assertEquals(actualMsg, "fine");
	}

	@Test
	public void t05_highToLowh() {
		inventory item1 = new inventory(driver);
		String actualMsg = item1.sortHighToLow();
		assertEquals(actualMsg, "fine");
	}

	@Test
	public void t06_ZToA() {
		inventory item1 = new inventory(driver);
		item1.sortZToA();
	}

	@Test 
	public void t07_logOut() { 
		inventory item1 = new inventory(driver);
		item1.logOut(); 
		login lg = new login(driver); 
		String actualMsg = lg.loginAfterLogout(); 
		assertEquals(actualMsg, "Accepted usernames are:"); 
	}

}
