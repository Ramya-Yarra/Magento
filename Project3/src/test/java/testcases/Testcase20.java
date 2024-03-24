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

public class Testcase20 extends DataDriven {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginpage;

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
	public void myAccount() {
		String expectedMessage = "Welcome, Ramya Yarra!";
		Assert.assertTrue(loginpage.getWelcomeMessageText().contains(expectedMessage),
				"Welcome message doesn't match expected");
		homePage.clickdropdown();
		homePage.clickmyaccount();
		String expectedContactInfo = "Ramya Yarra\nYarra@gmail.com";
		Assert.assertEquals(loginpage.getContactInformation(), expectedContactInfo, "Contact information mismatch");
		Assert.assertEquals(loginpage.getDefaultBillingAddress(), "Billing address is not Displayed");
		Assert.assertEquals(loginpage.getDefaultShippingAddress(), "Shipping address is not Displayed");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
