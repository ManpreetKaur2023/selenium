package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class CheckOut  extends TestBase{
	
	public CheckOut() {
PageFactory.initElements(wd, this);
	}
	
	@BeforeMethod
	public void setUp() {
		intialisation();
	}
	
	
	@FindBy(css = "#BillingNewAddress_FirstName")
	private WebElement firstNameField;
	
	@FindBy(css = "#BillingNewAddress_LastName")
	private WebElement lastNameField;
	
	@FindBy(css = "#BillingNewAddress_Email")
	private WebElement emailField;
	
	
	
	@FindBy(css = "#BillingNewAddress_Company")
	private WebElement companyNameField;
	
	@FindBy(css = "#BillingNewAddress_CountryId")
	private WebElement country;
	

	@FindBy(css = "#BillingNewAddress_City")
	private WebElement cityField;
	
	
	@FindBy(css = "#BillingNewAddress_Address1")
	private WebElement address1Field;
	
	@FindBy(css = "#BillingNewAddress_Address2")
	private WebElement address2Field;
	
	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	private WebElement postalCodeField;
	
	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	private WebElement phoneNumberField;
	
	
	@FindBy(css = "#BillingNewAddress_FaxNumber")
	private WebElement faxNumberField;
	
	@FindBy(css = "#billing-buttons-container button:nth-of-type(4)")
	private WebElement continueBtn;
	
	
	@FindBy(css = "#shippingoption_2")
	private WebElement shippingMethodRadioBtn;
	
	@FindBy(xpath = "(//button[text()='Continue'])[3]")
	private WebElement continueBtnAfterShippingMethod;
	
	@FindBy(css = "#paymentmethod_1")
	private WebElement paymentMethodRadioBtn;
	
	@FindBy(xpath = "(//button[text()='Continue'])[4]")
	private WebElement continueBtnAfterPaymentMethod;
	
	@FindBy(xpath = "(//button[text()='Continue'])[5]")
	private WebElement continueBtnAfterpaymentInformation;
	
	@FindBy(xpath = "(//button[text()='Confirm'])")
	private WebElement confirmBtn;
	
	
	@FindBy(css = "div.page-title h1")
	private WebElement thankYouText;
	
	
	
	public void enterFirstName() {
		firstNameField.sendKeys("Manpreet");
	}
	
	public void enterLastName() {
		lastNameField.sendKeys("kaur");
	}
	
	public void enterEmail() {
		emailField.sendKeys("manu12@gmail.com");
	}

	public void enterCompanyName() {
		companyNameField.sendKeys("Pivot");
	}
	
	public void selectCountry() {
	Select sc=new Select(country);
	sc.selectByValue("168");
	}
	
	public void entercityField() {
		cityField.sendKeys("abs");
	}
	
	
	public void enterAddress1Fiels() {
		address1Field.sendKeys("hello");
	}
	
	
	
	
	public void enterAddress2Fiels() {
		address2Field.sendKeys("qwerty");
	}
	
	public void enterPostalCodeField() {
		postalCodeField.sendKeys("n9iiju");
	}
	
	
	public void enterPhoneNumber() {
		phoneNumberField.sendKeys("123456789");
	}
	
	
	
	
	public void enterFaxNumberField() {
		faxNumberField.sendKeys("23344");
	}
	
	public CheckOut selectContinueBtn() {
		continueBtn.click();
		return new CheckOut();
	}
	
	
	public void selectShippingMethodRadioBtn() {
		shippingMethodRadioBtn.click();
	}

	public CheckOut selectContinueBtnAfterShippingMethod() {
		continueBtnAfterShippingMethod.click();
		return new CheckOut();
	}
	
	
	public void selectPaymentMethodRadioBtn() {
		paymentMethodRadioBtn.click();
	}

	public CheckOut selectContinueBtnAfterpaymentMethod() {
		continueBtnAfterPaymentMethod.click();
		return new CheckOut();
	}
	
	public CheckOut selectContinueBtnAfterpaymentInformation() {
		continueBtnAfterpaymentInformation.click();
		return new CheckOut();
	}
	
	
	public CheckOut selectConfirmBtn() {
		confirmBtn.click();
		return new CheckOut();
	}
	
	
	
	public String showThankyouTextMessage() {
		String text=thankYouText.getText();
		return text;
	}
	
	
	
	
	@AfterMethod
	public void quit() {
		tearDown();
	}


}
