package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomensCategoryPage {

	private WebDriver driver;

	public WomensCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span[data-ui-id='page-title-wrapper']")
	private WebElement pageTitleElement;

	@FindBy(xpath = "//a[contains(text(),'Hoodies & Sweatshirts')]")
	private WebElement hoodiesAndSweatshirtsLink;

	@FindBy(css = "div.product-item-info")
	private WebElement productItem;

	@FindBy(css = "div.swatch-option.text[option-label='L']")
	private WebElement sizeL;

	@FindBy(css = "div.swatch-option.color[option-label='Gray']")
	private WebElement colorGray;

	@FindBy(css = "button.action.tocart.primary")
	private WebElement addToCartButton;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	private WebElement successMessage;

	public String getPageTitleText() {
		return pageTitleElement.getText();
	}

	public void clickHoodiesAndSweatshirtsLink() {
		hoodiesAndSweatshirtsLink.click();
	}

	public void hoverOverProduct() {
		Actions actions = new Actions(driver);
		actions.moveToElement(productItem).perform();
	}

	public void selectSizeL() {
		sizeL.click();
	}

	public void selectColorGray() {
		colorGray.click();
	}

	public void clickAddToCart() {
		addToCartButton.click();
	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText().trim();
	}
}
