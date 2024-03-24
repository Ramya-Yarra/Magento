package testcases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.WhatsNewPage;

public class Testcase6 {
	private WebDriver driver;
	private HomePage homePage;
	private WhatsNewPage whatsnewPage;

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
		whatsnewPage = new WhatsNewPage(driver);

	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void productnavigation() {
		homePage.getwhatsNewLink();
		String pageTitle = whatsnewPage.getWhatsNewPageTitle();
		Assert.assertEquals(pageTitle, "What's New", "Page title doesn't match");
	}

	@Test(priority = 3)
	public void verifyWomensCategories() {
		List<WebElement> womensCategories = whatsnewPage.getWomensCategories();
		Assert.assertTrue(womensCategories.size() > 0, "No women's categories found");
	}

	@Test(priority = 4)
	public void verifyMensCategories() {
		List<WebElement> mensCategories = whatsnewPage.getMensCategories();
		Assert.assertTrue(mensCategories.size() > 0, "No men's categories found");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
