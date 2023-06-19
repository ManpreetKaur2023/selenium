package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class DemoStore extends TestBase {

	 public DemoStore() {
		PageFactory.initElements(wd, this);
	}
	 Actions action;

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "div.header-links li:first-of-type")
	private WebElement registerBtn;
	

	@FindBy(css = "a.ico-login")
	private WebElement loginBtn;

	public Register clickRegisterBtn() {
		registerBtn.click();
		return new Register();
	}
	
	public Login clickLoginBtn() {
		loginBtn.click();
		return new Login();
	}
	
	

	@FindBy(xpath = "(//a[text()='Computers '])[1]")
	private WebElement computersBtn;
	
	
	@FindBy(xpath = "(//a[text()='Desktops '])[1]")
	private WebElement desktopsBtn;
	
	
	public void selectComputerOption() {
		action=new Actions(wd);
		action.moveToElement(computersBtn).perform();
		
		
		
	}
	
	
	public Desktops clickDesktopsBtn() {
		desktopsBtn.click();
		return new Desktops();
		
	}
	
	
	
	@FindBy(xpath = "//h2[text()='Welcome to our store']")
	private WebElement welcomeMessageAfterLogin;
	
	
	
	public String getWelcomeMessageAfterLogin() {
		return welcomeMessageAfterLogin.getText();
		
		
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
