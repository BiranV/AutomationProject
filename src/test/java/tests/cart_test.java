package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.inventory;
import pageobjects.login;
import pageobjects.cart;
import pageobjects.checkout_step_one;

public class cart_test extends base_test{

	@Test
	public void t01_loginSucceed() throws InterruptedException {
		login lp = new login(driver);
		lp.login("standard_user", "secret_sauce");
		inventory in = new inventory(driver);
		String actualMsg = in.loginSuccess();
		Assert.assertEquals(actualMsg, "Products");
	}

	@Test
	public void t02_addListItems() {
		inventory item = new inventory(driver);
		item.chooseToItemsList("Sauce Labs Bike Light");
		item.chooseToItemsList("Test.allTheThings() T-Shirt (Red)");
		item.chooseToItemsList("Sauce Labs Bolt T-Shirt");
		item.chooseToItemsList("Sauce Labs Onesie");
		item.openCart();
		cart ca = new cart(driver);
		String actualMsg = ca.valueOfItems();
		Assert.assertEquals(actualMsg, "4");
	}

	@Test
	public void t03_remvoeItem() {
		cart ca = new cart(driver);
		ca.removeItem();
		cart ca_two = new cart(driver);
		String actualMsg = ca_two.valueOfItems();
		Assert.assertEquals(actualMsg, "3");
	} 

	@Test
	public void t04_continueShopping() {
		cart ca = new cart(driver);
		ca.continueShopping();
		inventory item = new inventory(driver);
		item.openCart(); // open cart again for the next test
		cart ca_two = new cart(driver);
		String actualMsg = ca_two.backToCart();
		Assert.assertEquals(actualMsg, "DESCRIPTION");
	}

	@Test
	public void t05_numOfItems() throws InterruptedException {
		cart ca = new cart(driver);
		ca.numOfItems();
		cart ca_two = new cart(driver);
		String actualMsg = ca_two.valueOfItems();
		Assert.assertEquals(actualMsg, "3");
	}

	@Test
	public void t06_clickCheckOut() {
		cart ca = new cart(driver);
		ca.checkout();
		checkout_step_one co = new checkout_step_one(driver);
		String actualMsg = co.titleCheckout();
		Assert.assertEquals(actualMsg, "Checkout: Your Information");
	}
	
}
