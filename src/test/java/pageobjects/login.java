package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login extends base_page {

	@FindBy(css = "#user-name")
	private WebElement userField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "[value='LOGIN']")
	private WebElement loginBtn;
	@FindBy(css = "[data-test='error']")
	private WebElement errormsg;
	@FindBy(css = "#login_credentials>h4")
	private WebElement acceptedUserName;

	public login(WebDriver driver) {
		super(driver);
	}

	public void login(String user, String password) throws InterruptedException {
		fillText(userField, user);
		fillText(passwordField, password);
		Thread.sleep(1000);
		click(loginBtn);
	}

	public String errorMsg() {
		String error = errormsg.getText();
		return error;
	}

	public String loginAfterLogout() {
		String lal = acceptedUserName.getText();
		return lal;
	}
	
}
