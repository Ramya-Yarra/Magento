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

import pom.HomePage;
import pom.WomensCategoryPage;

public class Testcase13 {
	private WebDriver driver;
	private HomePage homePage;
	private WomensCategoryPage womensPage;

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
		womensPage = new WomensCategoryPage(driver);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void WomensCategory() {
		homePage.getwomenCategoryLink();
		String pageTitleText = womensPage.getPageTitleText();
		Assert.assertTrue(pageTitleText.contains("Women"), "Page title contains 'Women'");
		womensPage.clickHoodiesAndSweatshirtsLink();
	}

	@Test(priority = 3)
	public void addtocart() {
		setZoomLevel(driver, 0.8);
		womensPage.hoverOverProduct();
		womensPage.selectSizeL();
		womensPage.selectColorGray();
		womensPage.clickAddToCart();
		String successMessage = womensPage.getSuccessMessage();
		Assert.assertTrue(successMessage.contains("You added Circe Hooded Ice Fleece to your shopping cart"),
				"Message is not Displayed");
	}

	private void setZoomLevel(WebDriver driver, double zoomLevel) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "document.body.style.transform = 'scale(' + arguments[0] + ')';document.body.style.transformOrigin = '0.100';";
		jsExecutor.executeScript(script, zoomLevel);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
