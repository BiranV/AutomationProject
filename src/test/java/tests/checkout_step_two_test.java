package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.inventory;
import pageobjects.login;
import pageobjects.cart;
import pageobjects.checkout_complete;
import pageobjects.checkout_step_one;
import pageobjects.checkout_step_two;

public class checkout_step_two_test extends base_test {

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
	public void t03_clickCheckOut() {
		cart ca = new cart(driver);
		ca.checkout();
		checkout_step_one co = new checkout_step_one(driver);
		String actualMsg = co.titleCheckout();
		Assert.assertEquals(actualMsg, "Checkout: Your Information");
	}

	@Test
	public void t04_personalCorrectDetails() throws InterruptedException {
		checkout_step_one co = new checkout_step_one(driver);
		co.fillDetails("Biran", "Varon", "7530249");
		checkout_step_two ov = new checkout_step_two(driver);
		String actualMsg = ov.titleOverview();
		Assert.assertEquals(actualMsg, "Checkout: Overview");
	}

	@Test
	public void t05_printSauceCard() {
		checkout_step_two ov = new checkout_step_two(driver);
		ov.numSaurceCard();
		String val = ov.valSaurceCard();
		Assert.assertEquals(val, "SauceCard #31337");
	}

	@Test
	public void t06_printItemTotal() {
		checkout_step_two ov = new checkout_step_two(driver);
		ov.itemTotal();
		String val = ov.valItemTotal();
		Assert.assertEquals(val, "Item total: $105.96000000000001");
	}

	@Test
	public void t07_printTax() {
		checkout_step_two ov = new checkout_step_two(driver);
		ov.tax();
		String val = ov.valTax();
		Assert.assertEquals(val, "Tax: $8.48");
	}

	@Test
	public void t08_printTotal() {
		checkout_step_two ov = new checkout_step_two(driver);
		ov.total();
		String val = ov.valTotal();
		Assert.assertEquals(val, "Total: $114.44");
	}

	@Test
	public void t09_finish() { 
		checkout_step_two ov = new checkout_step_two(driver);
		ov.finish();
		checkout_complete fs = new checkout_complete(driver);
		String val = fs.titleFinish();
		Assert.assertEquals(val, "Finish");
	}
}
