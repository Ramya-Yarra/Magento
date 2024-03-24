package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	private WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	private WebElement Firstname;

	@FindBy(id = "lastname")
	private WebElement Lastname;

	@FindBy(id = "email_address")
	private WebElement emailid;

	@FindBy(id = "password")
	private WebElement Password;

	@FindBy(id = "password-confirmation")
	private WebElement PasswordConfirmation;

	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement createaccountbutton;

	@FindBy(xpath = "//div[@class='page messages']/div/div/div/div")
	private WebElement accountcreatedmsg;

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement failedaccountcreatemsg;

	@FindBy(linkText = "Edit")
	private WebElement editaccount;

	@FindBy(xpath = "//button[@title='Save']")
	private WebElement savebutton;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement accountedittext;

	@FindBy(xpath = "//a[normalize-space()='My Orders']")
	private WebElement myorder;

	@FindBy(id = "my-orders-table")
	private List<WebElement> tableRows;

	@FindBy(xpath = "//div[@class='checkout-success']//p[1]")
	private WebElement OrderID;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	private WebElement dropdown;

	@FindBy(linkText = "My Account")
	private WebElement myaccount;

	public void enterFirstname(String firstname) {
		Firstname.sendKeys(firstname);
	}

	public void enterLastname(String lastname) {
		Lastname.sendKeys(lastname);
	}

	public void enterEmail(String Email) {
		emailid.sendKeys(Email);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void confirmPassword(String password) {
		PasswordConfirmation.sendKeys(password);
	}

	public void clickCreateAccount() {
		createaccountbutton.click();
	}

	public String getAccountCreatedSuccessfulMessage() {
		return accountcreatedmsg.getText();
	}

	public String getfailedaccountText() {
		return failedaccountcreatemsg.getText();
	}

	public void editaccnt() {
		editaccount.click();
	}

	public void clearFields() {
		Firstname.clear();
		Lastname.clear();
	}

	public void clickSave() {
		savebutton.click();
	}

	public String accounteditMsg() {
		String edittext = accountedittext.getText();
		return edittext;
	}

	public void clickMyorder() {
		myorder.click();
	}

	public boolean verifyOrderinOrderTable() {
		String orderdetail = OrderID.getText();
		System.out.println(orderdetail);
		String[] arrOfStr = orderdetail.split(":", 2);
		String orderno = arrOfStr[1].replaceAll("[.]", "");
		System.out.println(orderno);
		dropdown.click();
		myaccount.click();
		myorder.click();
		boolean found = false;
		int ttlRows = tableRows.size();
		for (int i = 1; i <= ttlRows; i++) {
			WebElement orders = driver
					.findElement(By.xpath("//table[@id='my-orders-table']//tbody/tr[" + i + "]/td[1]"));
			String actualorderid = orders.getText();
			System.out.println("The Order ID from table: " + actualorderid);
			if (actualorderid.equals(orderno)) {
				found = true;
			}
		}
		return found;
	}
}
