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

public class Testcase19 {
	private WebDriver driver;
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
		homePage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void HomePage() throws InterruptedException {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
		homePage.gettrainingCategoryLink();
		homePage.clickDownloadLink();
		String expectedTitle = "Video Download";
		Assert.assertEquals(homePage.getDownloadPageTitleText(), expectedTitle, "Page title mismatch");
		String expectedMessage = "We can't find products matching the selection.";
		Assert.assertEquals(homePage.getEmptyMessageText(), expectedMessage, "Empty message mismatch");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
