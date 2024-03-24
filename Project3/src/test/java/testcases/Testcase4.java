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
import pom.ProductDetailsPage;
import pom.ProductPage;

public class Testcase4 extends DataDriven {
	private WebDriver driver;
	private ProductPage productPage;
	private ProductDetailsPage productDetails;

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
		productPage = new ProductPage(driver);
		productDetails = new ProductDetailsPage(driver);

	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void productnavigation() {
		productPage.getRadiantTeeLink();
	}

	@Test(priority = 3, dataProvider = "reviewData")
	public void verifyCustomerReviewsBlockTitle(int stars, String nicknamefield, String summaryfield,
			String reviewfield) {
		productPage.clickReviewsTab();
		productPage.reviewTabTitle();
		productDetails.selectRating(stars);
		productDetails.Nickname(nicknamefield);
		productDetails.Summary(summaryfield);
		productDetails.Review(reviewfield);
		productDetails.ClickSubmit();
		String successMsg = productDetails.getSuccessmsg();
		if (successMsg.contains("You submitted your review for moderation.")) {
			Assert.assertTrue(true);
			System.out.println("Verified Review success message");
		} else {
			Assert.assertTrue(false);
			System.out.println("Review success message failed");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
