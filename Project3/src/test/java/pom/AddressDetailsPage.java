package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsPage {
	public AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	private WebElement firstname;

	@FindBy(id = "lastname")
	private WebElement lastname;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "telephone")
	private WebElement telephone;

	@FindBy(id = "street_1")
	private WebElement street_1;

	@FindBy(id = "street_2")
	private WebElement street_2;

	@FindBy(id = "street_3")
	private WebElement street_3;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "region")
	private WebElement state;

	@FindBy(id = "region_id")
	private WebElement stateDropdown;

	@FindBy(id = "zip")
	private WebElement postalcode;

	@FindBy(id = "country")
	private WebElement countryDropdown;

	public void setContactInformation(String firstName, String lastName, String company, String phoneNumber) {
		clearText(this.firstname);
		this.firstname.sendKeys(firstName);

		clearText(this.lastname);
		this.lastname.sendKeys(lastName);

		this.company.sendKeys(company);
		this.telephone.sendKeys(phoneNumber);
	}

	private void clearText(WebElement element) {
		element.clear();
	}

	public void setStreetAddress(String address1, String address2, String address3) {
		this.street_1.sendKeys(address1);
		this.street_2.sendKeys(address2);
		this.street_3.sendKeys(address3);
	}

	public void setCity(String city) {
		this.city.sendKeys(city);
	}

	public void setStateDropdown(String state) {
		Select select = new Select(stateDropdown);
		select.selectByVisibleText(state);
	}

	public void setState(String state) {
		this.state.sendKeys(state);
	}

	public void setPostalCode(String postalCode) {
		this.postalcode.sendKeys(postalCode);
	}

	public void setCountryDropdown(String country) {
		Select select = new Select(countryDropdown);
		select.selectByVisibleText(country);
	}
}
