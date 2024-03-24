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
import pom.HomePage;
import pom.LoginPage;

public class Testcase10 extends DataDriven {
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

	@Test(priority = 2, dataProvider = "invalidLoginCredentials")
	public void signinAccount(String Email, String password) {
		homePage.clicksignin();
		loginpage.getlogintext();
		loginpage.clicksigin();
		loginpage.enteremailid(Email);
		loginpage.enterpassword(password);
		loginpage.clicksigin();
		homePage.failedtosignin();
		ScreenshotUtility.takeScreenshot(driver, "FailedtoSignin");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
