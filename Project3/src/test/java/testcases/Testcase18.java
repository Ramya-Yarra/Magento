package testcases;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.GarCategoryPage;
import pom.HomePage;

public class Testcase18 {
	private WebDriver driver;
	private HomePage homePage;
	private GarCategoryPage bagsPage;

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
		bagsPage = new GarCategoryPage(driver);
	}

	@Test(priority = 1)
	public void HomePage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
		homePage.getgearCategoryLink();
		homePage.clickBagsLink();
		String expectedTitle = "Bags";
		String actualTitle = bagsPage.getPageTitleText();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match.");
	}

	@Test(priority = 2)
	public void addtocompare() {
		setZoomLevel(driver, 0.6);
		bagsPage.hoverOverProductImage1();
		bagsPage.clickAddToCompareButton();
		String messageText = bagsPage.getMessageText();
		Assert.assertTrue(messageText.contains("You added product Push It Messenger Bag to the comparison list"),
				"Message does not contain expected text");
		setZoomLevel(driver, 0.6);
		bagsPage.hoverOverProductImage2();
		bagsPage.clickAddToCompareButton();
		bagsPage.clickCompareButton();
	}

	private void setZoomLevel(WebDriver driver, double zoomLevel) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "document.body.style.transform = 'scale(' + arguments[0] + ')';document.body.style.transformOrigin = '0.100';";
		jsExecutor.executeScript(script, zoomLevel);
	}

	@Test(priority = 3)
	public void compareproducts() {
		bagsPage.getCompareProductsTitle();
		String productName1 = bagsPage.getProductName();
		String ratingPercentage1 = bagsPage.getProductRatingPercentage();
		String productPrice1 = bagsPage.getProductPrice();
		String productName2 = bagsPage.getProductName();
		String ratingPercentage2 = bagsPage.getProductRatingPercentage();
		String productPrice2 = bagsPage.getProductPrice();
		Assert.assertTrue(productName1.equals(productName2));
		Assert.assertTrue(ratingPercentage1.equals(ratingPercentage2));
		Assert.assertTrue(productPrice1.equals(productPrice2));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
