package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".billing-address-details")
	private WebElement billingAddressDetails;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	private WebElement next;

	@FindBy(xpath = "//span[normalize-space()='Place Order']")
	private WebElement placeorder;

	@FindBy(xpath = "//span[@class='base']")
	private WebElement placeorderSucessmsg;

	@FindBy(xpath = "//a[@class='action print']")
	private WebElement printrecipt;

	@FindBy(xpath = "//span[normalize-space()='Continue Shopping']")
	private WebElement continueshopping;

	@FindBy(xpath = "//a[@class='action print']")
	private WebElement printreceipt;

	@FindBy(xpath = "//strong[@class='product name product-item-name']")
	private WebElement productnameinprintrcpt;

	public void ClickonNext() {
		next.click();
	}

	public boolean isBillingAddressDisplayed() {
		return billingAddressDetails.isDisplayed();
	}

	public String getBillingAddressText() {
		return billingAddressDetails.getText();
	}

	public void clickonPlaceorder() {
		placeorder.click();
	}

	public String getSuccessmsgPlaceorder() {
		return placeorderSucessmsg.getText();
	}

	public void clickoncountinueShopping() {
		continueshopping.click();
	}

	public void clickonprintrept() {
		printreceipt.click();
	}

	public String getproductName() {
		return productnameinprintrcpt.getText();
	}
}
