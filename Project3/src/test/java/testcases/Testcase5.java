package testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.SalesPage;

public class Testcase5 {
	private WebDriver driver;
	private SalesPage salesPage;
	private HomePage homePage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing\\Selenium\\Jar files\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("./Extensions/uBlock Origin 1.56.0.0.crx"));
		driver = new ChromeDriver(opt);
		opt.addArguments("--headless");
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		salesPage = new SalesPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void saleslink() {
		homePage.getsaleCategoryLink();
		salesPage.getSalesPageTitle();
		salesPage.clickonWomensDeals();
		String pageTitle = salesPage.getPageTitle();
		Assert.assertEquals(pageTitle, "Women Sale", "Page title does not match expected value");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
