package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensCategoryPage {
	private WebDriver driver;

	public MensCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span[data-ui-id='page-title-wrapper']")
	private WebElement pageTitleElement;

	@FindBy(xpath = "//img[@alt='Marco Lightweight Active Hoodie']")
	private WebElement MarcoHoodie;

	@FindBy(css = "div.swatch-option.text[option-label='L']")
	private WebElement sizeL;

	@FindBy(css = "div.swatch-option.color[option-label='Gray']")
	private WebElement colorGray;

	@FindBy(css = "button.action.tocart.primary")
	private WebElement addToCartButton;

	public String getPageTitleText() {
		return pageTitleElement.getText();
	}

	public void clickonMarcoHoodie() {
		MarcoHoodie.click();
	}

	public void hoverOverProduct() {
		Actions actions = new Actions(driver);
		actions.moveToElement(MarcoHoodie).perform();
	}

	public void selectSizeL() {
		sizeL.click();
	}

	public void selectColorGray() {
		colorGray.click();
	}

	public void clickAddToCart() {
		addToCartButton.click();
	}
}
