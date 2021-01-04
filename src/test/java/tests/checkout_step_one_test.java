package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.inventory;
import pageobjects.login;
import pageobjects.cart;
import pageobjects.checkout_step_one;
import pageobjects.checkout_step_two;

public class checkout_step_one_test extends base_test {

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
		Assert.assertEquals(actualMsg, "4", "exepted for 4 items");
	}

	@Test
	public void t03_clickCheckOut() {
		cart ca = new cart(driver);
		ca.checkout();
		checkout_step_one co = new checkout_step_one(driver);
		String actualMsg = co.titleCheckout();
		Assert.assertEquals(actualMsg, "Checkout: Your Information");
	}

	@Test
	public void t04_personalWrongFirstName() throws InterruptedException {
		checkout_step_one co = new checkout_step_one(driver);
		co.fillDetails("", "Varon", "7530249");
		String expected = "Error: First Name is required";
		String actual = co.errorMsg();
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void t05_personalCorrectDetails() throws InterruptedException {
		checkout_step_one co = new checkout_step_one(driver);
		co.fillDetails("Biran", "Varon", "7530249");
		checkout_step_two ov = new checkout_step_two(driver);
		String actualMsg = ov.titleOverview();
		Assert.assertEquals(actualMsg, "Checkout: Overview");
	}
}
