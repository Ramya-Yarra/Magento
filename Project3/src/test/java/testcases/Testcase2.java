package testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.ProductPage;

public class Testcase2 {
	private WebDriver driver;
	private ProductPage productPage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Testing\\Selenium\\Jar files\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("./Extensions/uBlock Origin 1.56.0.0.crx"));
		driver = new ChromeDriver(opt);
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		productPage = new ProductPage(driver);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void productnavigation() {
		productPage.getRadiantTeeLink();
		String actualText = productPage.getproductdetailpagetitle();
		String expectedText = "Radiant Tee";
		Assert.assertEquals(actualText, expectedText);
		Assert.assertTrue(productPage.getProductName().length() > 0, "Product name is not visible");
		Assert.assertTrue(productPage.getProductPrice().length() > 0, "Product price is not visible");
		Assert.assertTrue(productPage.getProductAvailability().length() > 0, "Product availability is not visible");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
