package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {
	public SalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='base']")
	private WebElement salespageTitle;

	@FindBy(xpath = "//div[@class='blocks-promo']/a/img")
	private WebElement womensDeals;

	@FindBy(css = "span.base[data-ui-id='page-title-wrapper']")
	private WebElement pageTitle;

	public String getSalesPageTitle() {
		return salespageTitle.getText();
	}

	public void clickonWomensDeals() {
		womensDeals.click();
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}
}
