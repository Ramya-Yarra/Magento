package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='base']")
	private WebElement logintext;

	@FindBy(id = "email")
	private WebElement emailid;

	@FindBy(id = "pass")
	private WebElement password;

	@FindBy(id = "send2")
	private WebElement signinbutton;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement wishlisterrormsg;

	@FindBy(css = "span.logged-in[data-bind='text: new String(\"Welcome, %1!\").replace(\"%1\", customer().fullname)']")
	private WebElement welcomeMessage;

	@FindBy(css = "div.block-content div.box-content p")
	private WebElement contactInformation;

	@FindBy(css = "div.box-billing-address div.box-content address")
	private WebElement defaultBillingAddress;

	@FindBy(css = "div.box-shipping-address div.box-content address")
	private WebElement defaultShippingAddress;

	public String getWelcomeMessageText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement visibleWelcomeMessage = wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
		return visibleWelcomeMessage.getText();
	}

	public String getlogintext() {
		return logintext.getText();
	}

	public void enteremailid(String email) {
		emailid.sendKeys(email);
	}

	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}

	public void clicksigin() {
		signinbutton.click();
	}

	public String getlogintitle() {
		return driver.getTitle();
	}

	public String getErrorMsg() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(wishlisterrormsg));
		return element.getText();
	}

	public String getContactInformation() {
		return contactInformation.getText();
	}

	public String getDefaultBillingAddress() {
		return defaultBillingAddress.getText();
	}

	public String getDefaultShippingAddress() {
		return defaultShippingAddress.getText();
	}
}
