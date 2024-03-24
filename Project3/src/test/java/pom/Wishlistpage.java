package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wishlistpage {
	private WebDriver driver;

	public Wishlistpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement wishlistsuccessfullmsg;

	@FindBy(xpath = "//button[@data-role='tocart']//span[contains(text(),'Add to Cart')]")
	private WebElement addtocart;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement wishlistErrorMessage;

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getWishlistMessageText() {
		scrollToElement(wishlistsuccessfullmsg);
		return wishlistsuccessfullmsg.getText();
	}

	public void clickAddToCart() {
		scrollToElement(addtocart);
		addtocart.click();
	}

	public void clickonAddtocart() {
		addtocart.click();
	}

	public String getWishlistErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		scrollToElement(wishlistErrorMessage);
		wait.until(ExpectedConditions.visibilityOf(wishlistErrorMessage));
		return wishlistErrorMessage.getText();
	}
}
