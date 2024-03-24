package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage {
	public WhatsNewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".page-title")
	private WebElement whatsNewPageTitle;

	@FindBy(css = ".categories-menu")
	private WebElement categoriesMenu;

	@FindBy(xpath = "//strong[contains(., \"New in women's\")]/following-sibling::ul[@class='items']/li")
	private List<WebElement> womensCategories;

	@FindBy(xpath = "//strong[contains(., \"New in men's\")]/following-sibling::ul[@class='items']/li")
	private List<WebElement> mensCategories;

	@FindBy(xpath = "//a[contains(text(),'Hoodies & Sweatshirts')]")
	private WebElement hoodiesSweatshirts;

	@FindBy(xpath = "//span[@class='base' and @data-ui-id='page-title-wrapper']")
	private WebElement hoodiesSweatshirtsPageTitle;

	public String getWhatsNewPageTitle() {
		return whatsNewPageTitle.getText();
	}

	public List<WebElement> getWomensCategories() {
		return womensCategories;
	}

	public List<WebElement> getMensCategories() {
		return mensCategories;
	}

	public void getHoodiesSweatshirtsLink() {
		hoodiesSweatshirts.click();
	}

	public String getHoodiesSweatshirtsPageTitle() {
		return hoodiesSweatshirtsPageTitle.getText();
	}
}
