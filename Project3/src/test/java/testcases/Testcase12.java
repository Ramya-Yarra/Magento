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
import pom.HomePage;
import pom.LoginPage;
import pom.ProductPage;
import pom.Wishlistpage;

public class Testcase12 extends DataDriven {
	private WebDriver driver;
	private ProductPage productPage;
	private Wishlistpage wishlistPage;
	private LoginPage loginpage;
	private HomePage homePage;

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
		homePage = new HomePage(driver);
		loginpage = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2, dataProvider = "loginCredentials")
	public void createAccount(String Email, String password) {
		homePage.clicksignin();
		loginpage.getlogintext();
		loginpage.enteremailid(Email);
		loginpage.enterpassword(password);
		loginpage.clicksigin();
		String welcomeMessage = loginpage.getWelcomeMessageText();
		Assert.assertTrue(welcomeMessage.startsWith("Welcome,"), "Welcome message does not start with 'Welcome,'");
		Assert.assertTrue(welcomeMessage.endsWith("!"), "Welcome message does not end with '!'");
		Assert.assertTrue(welcomeMessage.contains("Ramya Yarra"),
				"Welcome message does not contain expected user name 'Ramya Yarra'");
	}

	@Test(priority = 3)
	public void addtoWishlist() {
		productPage.getRadiantTeeLink();
		productPage.clickAddToWishlist();
		String wishlistMessage = wishlistPage.getWishlistMessageText();
		Assert.assertTrue(wishlistMessage.contains("Radiant Tee has been added to your Wish List."),
				"Wishlist message does not contain expected text 'Radiant Tee has been added to your Wish List.'");
		Assert.assertTrue(wishlistMessage.contains("Click here to continue shopping."),
				"Wishlist message does not contain expected text 'Click here to continue shopping.'");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
