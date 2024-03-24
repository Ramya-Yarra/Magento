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

public class Testcase3 {
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
	}

	@Test(priority = 3)
	public void detailsDescriptionTab() {
		productPage.clickDescriptionTab();
		String actualDescription = productPage.getDetailsDescription();
		String expectedDescription = "So light and comfy, you'll love the Radiant Tee's organic fabric, feel, performance and style. You may never want to stop moving in this shirt.\n"
				+ "• Salmon soft scoop neck tee.\n" + "• Athletic, semi-form fit.\n" + "• Flat seams prevent chafing.\n"
				+ "• 67% Organic Cotton / 28% Hemp / 5% Spandex.";
		Assert.assertEquals(actualDescription, expectedDescription, "Product description does not match.");
	}

	@Test(priority = 4)
	public void moreAdditionalInfoTab() {
		productPage.clickAdditionalInfoTab();
		boolean isTableDisplayed = productPage.isAdditionalAttributesTableDisplayed();
		Assert.assertTrue(isTableDisplayed, "Additional attributes table is not displayed.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
