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
import basic.ScreenshotUtility;
import pom.CreateAccountPage;
import pom.HomePage;

public class Testcase7 extends DataDriven {
	private WebDriver driver;
	private HomePage homePage;
	private CreateAccountPage createpage;

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
		createpage = new CreateAccountPage(driver);

	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2, dataProvider = "signUpCredentials")
	public void createAccount(String firstname, String lastname, String Email, String password) {
		homePage.clickCreteAccount();
		createpage.enterFirstname(firstname);
		createpage.enterLastname(lastname);
		createpage.enterEmail(Email);
		createpage.enterPassword(password);
		createpage.confirmPassword(password);
		createpage.clickCreateAccount();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		createpage.getAccountCreatedSuccessfulMessage();
		ScreenshotUtility.takeScreenshot(driver, "AccountCreated");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
