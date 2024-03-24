package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.product-item-link[title='Radiant Tee']")
	private WebElement productLink;

	@FindBy(css = "h1.page-title span.base[data-ui-id='page-title-wrapper'][itemprop='name']")
	private WebElement productPageTitle;

	@FindBy(css = "span[data-ui-id='page-title-wrapper']")
	private WebElement productName;

	@FindBy(css = "span.price-wrapper .price")
	private WebElement productPrice;

	@FindBy(css = "div.stock")
	private WebElement productAvailability;

	@FindBy(id = "tab-label-description")
	private WebElement DetailsTab;

	@FindBy(xpath = "//div[@class='product attribute description']//div[@class='value']")
	private WebElement productDescription;

	@FindBy(id = "tab-label-additional")
	private WebElement additionalInfoTab;

	@FindBy(xpath = "//table[@id='product-attribute-specs-table']")
	private WebElement moreadditionalInfoTable;

	@FindBy(id = "tab-label-reviews")
	private WebElement reviewsTab;

	@FindBy(css = ".block-title strong")
	private WebElement reviewTitle;

	@FindBy(xpath = "//a[@class='product-item-link']")
	private WebElement producttext;

	@FindBy(css = "a.action.towishlist")
	private WebElement addToWishlistLink;

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement warningMsg;

	public void getRadiantTeeLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productLink);
		productLink.click();
	}

	public String getMessageText() {
		return warningMsg.getText();
	}

	public String getproductdetailpagetitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(productPageTitle));
		return productPageTitle.getText();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public String getProductAvailability() {
		return productAvailability.getText();
	}

	public void clickAddToWishlist() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToWishlistLink);
		addToWishlistLink.click();
	}

	public void clickDescriptionTab() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DetailsTab);
		DetailsTab.click();
	}

	public String getDetailsDescription() {
		return productDescription.getText();
	}

	public void clickAdditionalInfoTab() {
		additionalInfoTab.click();
	}

	public boolean isAdditionalAttributesTableDisplayed() {
		return moreadditionalInfoTable.isDisplayed();
	}

	public void clickReviewsTab() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewsTab);
		reviewsTab.click();
	}

	public String reviewTabTitle() {
		return reviewTitle.getText();
	}

	public String getproductTitle() {
		return producttext.getText();
	}

	public void mouseoverproduct() {
		Actions actions = new Actions(driver);
		actions.moveToElement(producttext).perform();
	}
}
