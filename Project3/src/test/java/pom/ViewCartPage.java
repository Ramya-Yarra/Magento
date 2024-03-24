package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {
	public ViewCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "qty")
	private WebElement quantityInput;

	@FindBy(name = "update_cart_action")
	private WebElement updateCartButton;

	@FindBy(className = "action checkout")
	private WebElement proceedToCheckoutButton;

	public void enterQuantity(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}

	public void clickUpdateCartButton() {
		updateCartButton.click();
	}

	public void clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}
}
