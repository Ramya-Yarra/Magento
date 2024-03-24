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

public class Testcase1 {
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
	public void testHomePageTitle() {
		Assert.assertTrue(homePage.logoDisplayed(), "Logo is not displayed.");
		String title = homePage.pageTitle();
		System.out.println("Page Title: " + title);
		Assert.assertTrue(title.contains("Home Page"), "Page title is not as expected.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
