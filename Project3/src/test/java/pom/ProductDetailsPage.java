package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement warning;

	@FindBy(xpath = "//span[@class='base']")
	private WebElement productname;

	@FindBy(id = "tab-label-additional-title")
	private WebElement moreinfo;

	@FindBy(id = "additional")
	private List<WebElement> additionalinfo;

	@FindBy(id = "tab-label-reviews-title")
	private WebElement reviewtitle;

	@FindBy(xpath = "//label[@id='Rating_5_label']")
	private WebElement tworating;

	@FindBy(id = "nickname_field")
	private WebElement nickname;

	@FindBy(id = "summary_field")
	private WebElement summary;

	@FindBy(id = "review_field")
	private WebElement review;

	@FindBy(xpath = "//span[normalize-space()='Submit Review']")
	private WebElement submitbutton;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement successfullmsg;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement productpagewarning;

	@FindBy(css = ".control.review-control-vote input:checked")
	private WebElement selectedRating;

	public String warn() {
		String warnmsg = warning.getText();
		return warnmsg;
	}

	public String productName() {
		return productname.getText();
	}

	public void ClickMoreInfo() {
		moreinfo.click();
	}

	public void additionalInfo() {
		for (WebElement webElement : additionalinfo) {
			String details = webElement.getText();
			System.out.println(details);
		}
	}

	public void clickreview() {
		reviewtitle.click();
	}

	public void clickstar() {
		Actions act = new Actions(driver);
		act.moveToElement(tworating).click().build().perform();
	}

	public void selectRating(int stars) {
		String ratingId = "Rating_" + stars;
		WebElement ratingElement = driver.findElement(By.id(ratingId));
		ratingElement.click();
	}

	public String getSelectedRatingValue() {
		return selectedRating.getAttribute("value");
	}

	public void Nickname(String nicknamefield) {
		nickname.sendKeys(nicknamefield);
		;
	}

	public void Summary(String summaryfield) {
		summary.sendKeys(summaryfield);
	}

	public void Review(String reviewfield) {
		review.sendKeys(reviewfield);
	}

	public void ClickSubmit() {
		submitbutton.submit();
	}

	public String getSuccessmsg() {
		return successfullmsg.getText();
	}

	public String productpagewarn() {
		return productpagewarning.getText();
	}

	public String gettitle() {
		return driver.getTitle();
	}
}
