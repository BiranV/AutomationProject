package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class base_page {
	WebDriver driver;

	public base_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
		Assert.assertEquals(el.getAttribute("value"), text);
	}

	public void click(WebElement el) {
		el.click();
	}
	
}
