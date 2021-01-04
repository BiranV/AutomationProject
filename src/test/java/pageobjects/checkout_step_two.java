package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout_step_two extends base_page {

	@FindBy(css = ".btn_action.cart_button")
	private WebElement finishBtn;
	@FindBy(css = ".summary_info > div:nth-child(2)")
	private WebElement saurceCard;
	@FindBy(css = ".summary_info > div.summary_subtotal_label")
	private WebElement itemTotal;
	@FindBy(css = ".summary_info > div.summary_tax_label")
	private WebElement tax;
	@FindBy(css = ".summary_info div.summary_total_label")
	private WebElement total;
	@FindBy(css = ".subheader")
	private WebElement titleOverviewPage;

	public checkout_step_two(WebDriver driver) {
		super(driver);
	}

	public void finish() {
		click(finishBtn);
	}

	public void numSaurceCard() {
		String num = saurceCard.getText();
		System.out.println(num);
	}

	public String valSaurceCard() {
		String val = saurceCard.getText();
		return val;
	}

	public void itemTotal() {
		String num = itemTotal.getText();
		System.out.println(num);
	}

	public String valItemTotal() {
		String val = itemTotal.getText();
		return val;
	}

	public void tax() {
		String num = tax.getText();
		System.out.println(num);
	}

	public String valTax() {
		String val = tax.getText();
		return val;
	}

	public void total() {
		String num = total.getText();
		System.out.println(num);
	}

	public String valTotal() {
		String val = total.getText();
		return val;
	}

	public String titleOverview() {
		String to = titleOverviewPage.getText();
		return to;
	}
	
}
