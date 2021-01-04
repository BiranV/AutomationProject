package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class inventory extends base_page {

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> list;
	@FindBy(css = "#shopping_cart_container > a > svg > path")
	private WebElement clickOpenCart;
	@FindBy(css = ".btn_primary.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = "#item_4_title_link > div")
	private WebElement nameOfItem;
	@FindBy(css = ".product_sort_container")
	private WebElement sortBtn;
	@FindBy(css = ".bm-burger-button")
	private WebElement menuBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement aboutBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutBtn;
	@FindBy(css = ".inventory_details_back_button")
	private WebElement clickBack;
	@FindBy(css = ".product_label")
	private WebElement loginsuccess;
	@FindBy(css = ".inventory_item_price")
	private List<WebElement> listPrice;


	public inventory(WebDriver driver) {
		super(driver);
	}

	public String loginSuccess() {
		String losc = loginsuccess.getText();
		return losc;
	}

	public void chooseToItemsList(String name) {
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(addToCartBtn);
				break;
			}
		}
	}

	public void nameOfItem() {
		click(nameOfItem);
	}

	public void addToCart() {
		click(addToCartBtn);
	}

	public String sortLowToHigh() {
		Select s = new Select(sortBtn);
		s.selectByValue("lohi");
		String res = null;

		//validation
		for (int i=1 ; i < listPrice.size() ; i++) {
			if (Double.valueOf(listPrice.get(i-1).getText().substring(1)) > Double.valueOf(listPrice.get(i).getText().substring(1))) {
				res = "error";
				break;
			}	else {
				res = "fine";
			}
		}
		return res;
	}

	public String sortHighToLow() {
		Select s = new Select(sortBtn);
		s.selectByValue("hilo");
		String res = null;

		//validation
		for (int i=1 ; i < listPrice.size() ; i++) {
			if (Double.valueOf(listPrice.get(i-1).getText().substring(1)) < Double.valueOf(listPrice.get(i).getText().substring(1))) {
				res = "error";
				break;
			}	else {
				res = "fine";
			}
		}
		return res;
	}

	public void sortZToA() {
		Select s = new Select(sortBtn);
		s.selectByValue("za");
	}

	public void about() {
		click(menuBtn);
		click(aboutBtn);
	}

	public void openCart() {
		click(clickOpenCart);
	}

	public void logOut() {
		click(menuBtn);
		click(logOutBtn);
	}

	public void back() {
		click(clickBack);
	}
	
}
