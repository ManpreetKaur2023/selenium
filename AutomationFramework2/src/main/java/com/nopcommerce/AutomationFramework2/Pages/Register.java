package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class Register extends TestBase {

	Register() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "#gender-female")
	private WebElement genderRadioBtnFemale;

	@FindBy(css = "#FirstName")
	private WebElement firstNameField;

	@FindBy(css = "#LastName")
	private WebElement lastnameField;

	@FindBy(css = "#Email")
	private WebElement emailField;

	@FindBy(css = "#Company")
	private WebElement companynameField;

	@FindBy(xpath = "(//input[@name='Newsletter'])[1]")
	private WebElement newsletterCheckBox;

	@FindBy(css = "#Password")
	private WebElement passweodField;

	@FindBy(css = "#ConfirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(id = "register-button")
	private WebElement registerBtn;

//	@FindBy(xpath = "//div[text()='Your registration completed']")
//	private WebElement registerBtnText;

//	@FindBy(id = "div.buttons")
//	private WebElement continueBtn;

	public void selectGender() {
		genderRadioBtnFemale.isSelected();
	}

	public void enterFirstName() {
		firstNameField.sendKeys("Manpreet");
	}

	public void enterLastName() {
		lastnameField.sendKeys("kaur");
	}

	public void enterEmail() {
		emailField.sendKeys("dj0@gmail.com");
	}

	public void enterCompanyName() {
		companynameField.sendKeys("Pivot");
	}

	public void selectNewsletterCheckBox() {
		newsletterCheckBox.isSelected();
	}

	public void enterPassword() {
		passweodField.sendKeys("Password1");
	}

	public void enterConfirmPasswordField() {
		confirmPasswordField.sendKeys("Password1");
	}

	public Register clickRegisterBtn() {
		registerBtn.submit();
		return new Register();
	}
//
//	public String getRegisterBtnText() {
//		return registerBtnText.getText();
//		
//	}
//	
	public String getRegisterTitle() {
		return wd.getTitle();
	}

//	public DemoStore clickContinueBtn() {
//		continueBtn.click();
//		return new DemoStore();
//	}

	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
