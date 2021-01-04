package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout_complete extends base_page {

	@FindBy(css = "#checkout_complete_container > h2")
	private WebElement completeHeader;
	@FindBy(css = "#checkout_complete_container div.complete-text")
	private WebElement completeText;
	@FindBy(css = ".bm-burger-button")
	private WebElement menuBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutBtn;
	@FindBy(css = ".subheader")
	private WebElement titleFinishPage;

	public checkout_complete(WebDriver driver) {
		super(driver);
	}
	
	public String titleFinish() {
		String tf = titleFinishPage.getText();
		return tf;
	}

	public void printHeader() {
		String aa = completeHeader.getText();
		System.out.println(aa);
	}

	public void printText() {
		String ab = completeText.getText();
		System.out.println(ab);
	}

	// validation
	public void finishMsg() {
		String c = completeHeader.getText();
		if (c.toLowerCase().contains("thank you")) {
			System.out.println("Order accepted! Good job!");
		} else {
			System.out.println("Test failed");
		}
	}

	public void logOut() {
		click(menuBtn);
		click(logOutBtn);
	}
	
}
