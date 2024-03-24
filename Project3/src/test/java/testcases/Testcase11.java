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
import pom.Wishlistpage;

public class Testcase11 {
	private WebDriver driver;
	private ProductPage productPage;
	private Wishlistpage wishlistPage;

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
		wishlistPage = new Wishlistpage(driver);

	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void addtoWishlist() {
		productPage.getRadiantTeeLink();
		productPage.clickAddToWishlist();
		String errorMessage = wishlistPage.getWishlistErrorMessage();
		Assert.assertEquals(errorMessage, "You must login or register to add items to your wishlist.",
				"Wishlist error message is not as expected.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
