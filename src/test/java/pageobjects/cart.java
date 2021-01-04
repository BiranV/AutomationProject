package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cart extends base_page {

	@FindBy(css = ".checkout_button")
	private WebElement clickCheckOut;
	@FindBy(css = "#cart_contents_container div:nth-child(6) button")
	private WebElement removeBtn;
	@FindBy(css = "#cart_contents_container div.cart_footer > a.btn_secondary")
	private WebElement continueBtn;
	@FindBy(css = ".fa-layers-counter.shopping_cart_badge")
	private WebElement valueOfItems;
	@FindBy(css = ".cart_desc_label")
	private WebElement backToCart;

	public cart(WebDriver driver) {
		super(driver);
	}

	public void checkout() {
		click(clickCheckOut);
	}

	public void removeItem() {
		click(removeBtn);
	}

	public void continueShopping() {
		click(continueBtn);
	}

	public void numOfItems() throws InterruptedException {
		Thread.sleep(1000);
		String num = valueOfItems.getText();
		double a = Double.valueOf(num);
		System.out.println("The number of the items is: " + a);
	}

	public String valueOfItems() {
		String noi = valueOfItems.getText();
		return noi;
	} 

	public String backToCart() {
		String btc = backToCart.getText();
		return btc;
	}
}
