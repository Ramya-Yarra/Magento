package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GarCategoryPage {
	private WebDriver driver;

	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	private WebElement pageTitle;

	@FindBy(xpath = "//img[@alt='Push It Messenger Bag']")
	private WebElement productImage1;

	@FindBy(css = "a.action.tocompare")
	private WebElement addToCompareLink;

	@FindBy(xpath = "//img[@alt='Driven Backpack']")
	private WebElement productImage2;

	@FindBy(className = "action compare primary")
	private WebElement compareButton;

	@FindBy(css = "div[data-bind*='prepareMessageForHtml']")
	private WebElement messageElement;

	@FindBy(css = "span.base[data-ui-id='page-title-wrapper']")
	private WebElement compareProductsTitle;

	@FindBy(xpath = "//tr[.//span[text()='Product']]")
	private WebElement productInfoRow;

	@FindBy(xpath = "//strong[@class='product-item-name']/a")
	private WebElement productNameLink;

	@FindBy(xpath = "//span[@class='rating-result']/span")
	private WebElement ratingPercentage;

	@FindBy(xpath = "//span[@class='price-wrapper']/span")
	private WebElement productPrice;

	public GarCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitleText() {
		return pageTitle.getText();
	}

	public void hoverOverProductImage1() {
		Actions actions = new Actions(driver);
		actions.moveToElement(productImage1).perform();
	}

	public void clickAddToCompareButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(addToCompareLink).click().perform();
	}

	public void hoverOverProductImage2() {
		Actions actions = new Actions(driver);
		actions.moveToElement(productImage2).perform();
	}

	public String getMessageText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(messageElement));
		return messageElement.getText();
	}

	public void clickCompareButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", compareButton);
		compareButton.click();
	}

	public WebElement getCompareProductsTitle() {
		return compareProductsTitle;
	}

	public WebElement getProductInfoRow() {
		return productInfoRow;
	}

	public String getProductName() {
		return productNameLink.getText();
	}

	public String getProductRatingPercentage() {
		return ratingPercentage.getText();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}
}
