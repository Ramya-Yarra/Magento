package testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basic.DataDriven;
import pom.HomePage;
import pom.LoginPage;
import pom.ViewCartPage;
import pom.AddressDetailsPage;
import pom.CheckoutPage;

public class Testcase16 extends DataDriven {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginpage;
	private ViewCartPage cartPage;
	private AddressDetailsPage addressPage;
	private CheckoutPage checkoutPage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing\\Selenium\\Jar files\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("./Extensions/uBlock Origin 1.56.0.0.crx"));
		driver = new ChromeDriver(opt);
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		cartPage = new ViewCartPage(driver);
		addressPage = new AddressDetailsPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2, dataProvider = "loginCredentials")
	public void signinAccount(String Email, String password) {
		homePage.clicksignin();
		loginpage.getlogintext();
		loginpage.clicksigin();
		loginpage.enteremailid(Email);
		loginpage.enterpassword(password);
		loginpage.clicksigin();
	}

	@Test(priority = 3)
	public void addtocart() {
		homePage.scrollToProductImage();
		homePage.selectSizeXL();
		homePage.selectColorBlue();
		homePage.clickAddToCart();
		String successMessage = homePage.getSuccessMessage();
		Assert.assertTrue(successMessage.contains("You added Radiant Tee to your  shopping cart"),
				"Message is not Displayed");
		homePage.ClickCart();
		homePage.clickViewAndEditCartLink();
	}

	@Test(priority = 4)
	public void viewcart() {
		cartPage.enterQuantity("2");
		cartPage.clickUpdateCartButton();
		cartPage.clickProceedToCheckoutButton();
	}

	@Test(priority = 5)
	public void addAddress() {
		addressPage.setContactInformation("Yarra", "Ramya", "ABC Company", "1234567890");
		addressPage.setStreetAddress("Street 1", "Street 2", "Street 3");
		addressPage.setCity("New York");
		addressPage.setStateDropdown("New York");
		addressPage.setPostalCode("12345");
		addressPage.setCountryDropdown("United States");
		checkoutPage.ClickonNext();
	}

	@Test(priority = 6)
	public void verifyBillingAddressDisplayed() {
		Assert.assertTrue(checkoutPage.isBillingAddressDisplayed(), "Billing address is not displayed.");
		String actualAddressContent = checkoutPage.getBillingAddressText();
		Assert.assertEquals(actualAddressContent, "Billing address content does not match.");
		checkoutPage.clickonPlaceorder();
		checkoutPage.getSuccessmsgPlaceorder();
		String confirmationMessage = checkoutPage.getSuccessmsgPlaceorder();
		Assert.assertTrue(confirmationMessage.contains("Thank you for your purchase!"),
				"Expected confirmation message is not displayed.");
		checkoutPage.clickoncountinueShopping();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
