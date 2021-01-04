package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout_step_one extends base_page {

	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement zipCodeField;
	@FindBy(css = "[type='submit']")
	private WebElement continueBtm;
	@FindBy(css = "[data-test='error']")
	private WebElement errormsg;
	@FindBy(css = ".subheader")
	private WebElement titleCheckoutPage;

	public checkout_step_one(WebDriver driver) {
		super(driver);
	}

	public void fillDetails(String firstName, String lastName, String zipCode) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(zipCodeField, zipCode);
		click(continueBtm);
	}

	public String errorMsg() {
		String a = errormsg.getText();
		return a;
	}

	public String titleCheckout() {
		String tc = titleCheckoutPage.getText();
		return tc;
	}
	
}
