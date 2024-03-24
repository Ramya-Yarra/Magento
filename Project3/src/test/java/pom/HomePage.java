package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	private WebElement logo;

	@FindBy(linkText = "Create an Account")
	private WebElement accntcreate;

	@FindBy(linkText = "Sign In")
	private WebElement signin;

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement signfail;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[1]/div/a/span/span/img")
	private WebElement radianttoCart;

	@FindBy(xpath = "//*[@id=\"option-label-size-143-item-170\"]")
	private WebElement sizeXL;

	@FindBy(xpath = "//*[@id=\"option-label-color-93-item-50\"]")
	private WebElement colorBlue;

	@FindBy(css = "a[href='https://magento.softwaretestingboard.com/what-is-new.html']")
	private WebElement whatsNewLink;

	@FindBy(css = "a[href='https://magento.softwaretestingboard.com/women.html']")
	private WebElement womenCategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Men']")
	private WebElement mensCategory;

	@FindBy(xpath = "//*[@id='ui-id-17']/span[2]")
	private WebElement menstopsCategory;

	@FindBy(xpath = "//*[@id='ui-id-19']")
	private WebElement jacketsMenProducts;

	@FindBy(xpath = "//span[normalize-space()='Gear']")
	private WebElement gearCategory;

	@FindBy(id = "ui-id-25")
	private WebElement bagsLink;

	@FindBy(xpath = "//span[normalize-space()='Training']")
	private WebElement trainingCategory;

	@FindBy(css = "a[href='https://magento.softwaretestingboard.com/sale.html']")
	private WebElement saleCategoryLink;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	private WebElement dropdown;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	@FindBy(linkText = "My Account")
	private WebElement myaccount;

	@FindBy(xpath = "//span[@class='base']")
	private WebElement signouttxt;

	@FindBy(id = "search")
	private WebElement searchTextField;

	@FindBy(xpath = "//*[@id='search_mini_form']/div[2]/button")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='maincontent']/div[1]/h1/span")
	private WebElement searchResultsStatus;

	@FindBy(xpath = "//img[@alt='Radiant Tee']")
	private WebElement radianttee;

	@FindBy(className = "action")
	private WebElement addToCartButton;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	private WebElement successMessage;

	@FindBy(xpath = "//a[@class='action showcart active']")
	private WebElement cart;

	@FindBy(xpath = "//span[contains(text(),'View and Edit Cart')]")
	private WebElement viewAndEditCartLink;

	@FindBy(id = "ui-id-28")
	private WebElement downloadLink;

	@FindBy(css = "span.base[data-ui-id='page-title-wrapper']")
	private WebElement downloadpageTitle;

	@FindBy(css = "div.message.info.empty")
	private WebElement emptyMessage;

	public void ClickCart() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cart);
		cart.click();
	}

	public void clickViewAndEditCartLink() {
		viewAndEditCartLink.click();
	}

	public boolean logoDisplayed() {
		return logo.isDisplayed();
	}

	public String pageTitle() {
		return driver.getTitle();
	}

	public void clickCreteAccount() {
		accntcreate.click();
	}

	public void clicksignin() {
		signin.click();
	}

	public void clickdropdown() {
		dropdown.click();
	}

	public void signout() {
		signout.click();
	}

	public String getsignoutText() {
		return signouttxt.getText();
	}

	public String failedtosignin() {
		return signfail.getText();
	}

	public void clickmyaccount() {
		myaccount.click();
	}

	public void scrollToProductImage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radianttoCart);
	}

	public void selectSizeXL() {
		sizeXL.click();
	}

	public void selectColorBlue() {
		colorBlue.click();
	}

	public void clickAddToCart() {
		addToCartButton.click();
	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText().trim();
	}

	public void getsaleCategoryLink() {
		saleCategoryLink.click();
	}

	public void gettrainingCategoryLink() throws InterruptedException {
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveToElement(trainingCategory).perform();
		trainingCategory.click();
	}

	public void getgearCategoryLink() throws InterruptedException {
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveToElement(gearCategory).perform();
	}

	public void clickBagsLink() {
		bagsLink.click();
	}

	public void hoverToMenCategoryMenu() throws InterruptedException {
		Thread.sleep(500);
		Actions actions = new Actions(driver);
		actions.moveToElement(mensCategory).perform();
	}

	public void hoverToTops() {
		Actions actions = new Actions(driver);
		actions.moveToElement(menstopsCategory).build().perform();
	}

	public void clickOnJackets() {
		jacketsMenProducts.click();
	}

	public void getwomenCategoryLink() {
		womenCategoryLink.click();
	}

	public void getwhatsNewLink() {
		whatsNewLink.click();
	}

	public void performSearch(String searchText) {
		searchTextField.clear();
		searchTextField.sendKeys(searchText);
		searchButton.click();
	}

	public String getSearchResultsStatusText() {
		return searchResultsStatus.getText();
	}

	public String getmenuItems() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whatsNewLink);
		return whatsNewLink.getText();
	}

	public void hoverOvertoRadianttee() {
		Actions actions = new Actions(driver);
		actions.moveToElement(radianttee).perform();
	}

	public void clickDownloadLink() {
		downloadLink.click();
	}

	public String getDownloadPageTitleText() {
		return downloadpageTitle.getText();
	}

	public String getEmptyMessageText() {
		return emptyMessage.getText();
	}
}
