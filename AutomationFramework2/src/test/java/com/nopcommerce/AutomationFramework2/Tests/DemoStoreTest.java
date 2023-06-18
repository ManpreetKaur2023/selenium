package com.nopcommerce.AutomationFramework2.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.AutomationFramework2.Base.TestBase;
import com.nopcommerce.AutomationFramework2.Pages.DemoStore;
import com.nopcommerce.AutomationFramework2.Pages.Login;
import com.nopcommerce.AutomationFramework2.Pages.Register;

public class DemoStoreTest extends TestBase {

	DemoStore demoStore;
	Register register;
	Login login;

	@BeforeMethod
	public void setUp() {
		intialisation();
		demoStore = new DemoStore();
	}

//	@Test(priority = 1)
//	public void validateUserRegister() {
//		register = demoStore.clickRegisterBtn();
//		register.selectGender();
//		register.enterFirstName();
//		register.enterLastName();
//		register.enterEmail();
//		register.enterCompanyName();
//		register.selectNewsletterCheckBox();
//		register.enterPassword();
//		register.enterConfirmPasswordField();
//		register = register.clickRegisterBtn();
////System.out.println(register.getRegisterBtnText());//////////
//
//		Assert.assertEquals(register.getRegisterTitle(), "nopCommerce demo store. Register", "Registeration Failed");
//
////demoStore=register.clickContinueBtn();////////////
//
//	}
//	@Test(priority = 2)
//public void validateLoginWithPositivrCredential() {
//		login=demoStore.clickLoginBtn();
//		login.enterEmail();
//		login.enterPassword();
//		demoStore=login.clickLoginBtn();
//		
//		Assert.assertEquals(wd.getTitle(), "nopCommerce demo store","You are on wrong page");
//	}

	@AfterMethod
	public void quit() {
		//tearDown();
	}

}
