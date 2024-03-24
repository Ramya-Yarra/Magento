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
import pom.MensCategoryPage;

public class Testcase14 {
	private WebDriver driver;
	private HomePage homePage;
	private MensCategoryPage mensPage;

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
		mensPage = new MensCategoryPage(driver);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Home Page"));
	}

	@Test(priority = 2)
	public void mouseHover() throws InterruptedException {
		homePage.hoverToMenCategoryMenu();
		homePage.hoverToTops();
		homePage.clickOnJackets();
		String pageTitleText = mensPage.getPageTitleText();
		Assert.assertTrue(pageTitleText.contains("Jackets"), "Page title contains 'Jackets'");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
