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
import pom.LoginPage;
import pom.ProductPage;
import pom.Wishlistpage;

public class Testcase17 {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginpage;
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
		homePage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		wishlistPage = new Wishlistpage(driver);
	}

	@Test(priority = 1)
	public void HomePage() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
		homePage.scrollToProductImage();
		productPage.clickAddToWishlist();
		String errorMessage = wishlistPage.getWishlistErrorMessage();
		Assert.assertEquals(errorMessage, "You must login or register to add items to your wishlist.",
				"Wishlist error message is not as expected.");
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
	public void wishlist() {
		wishlistPage.getWishlistMessageText();
		wishlistPage.clickAddToCart();
		String actualMessage = productPage.getMessageText();
		String expectedMessage = "You need to choose options for your item.";
		Assert.assertEquals(actualMessage, expectedMessage, "Message content does not match.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
