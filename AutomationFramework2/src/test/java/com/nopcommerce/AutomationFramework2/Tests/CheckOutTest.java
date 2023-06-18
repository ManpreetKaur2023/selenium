package com.nopcommerce.AutomationFramework2.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.AutomationFramework2.Base.TestBase;
import com.nopcommerce.AutomationFramework2.Pages.BuildYourOwnComputer;
import com.nopcommerce.AutomationFramework2.Pages.CheckOut;
import com.nopcommerce.AutomationFramework2.Pages.DemoStore;
import com.nopcommerce.AutomationFramework2.Pages.Desktops;
import com.nopcommerce.AutomationFramework2.Pages.Login;
import com.nopcommerce.AutomationFramework2.Pages.Register;
import com.nopcommerce.AutomationFramework2.Pages.ShoppingCart;

public class CheckOutTest extends TestBase {

	DemoStore demoStore;
	Register register;
	Login login;
	CheckOut checkout;
	Desktops desktops;
	ShoppingCart shoppingCart;
	BuildYourOwnComputer buildYourOwnComputer;

	@BeforeMethod
	public void setUp() {
		intialisation();
		demoStore = new DemoStore();
	}

	@Test(priority = 1)
	public void validateUserRegister() {
		register = demoStore.clickRegisterBtn();
		register.selectGender();
		register.enterFirstName();
		register.enterLastName();
		register.enterEmail();
		register.enterCompanyName();
		register.selectNewsletterCheckBox();
		register.enterPassword();
		register.enterConfirmPasswordField();
		register = register.clickRegisterBtn();
//System.out.println(register.getRegisterBtnText());

		Assert.assertEquals(register.getRegisterTitle(), "nopCommerce demo store. Register", "Registeration Failed");

//demoStore=register.clickContinueBtn();

	}

	@Test(priority = 2)
	public void validateLoginWithPositivrCredential() {
		login = demoStore.clickLoginBtn();
		login.enterEmail();
		login.enterPassword();
		demoStore = login.clickLoginBtn();

		Assert.assertEquals(wd.getTitle(), "nopCommerce demo store", "You are on wrong page");
	}
@Test(priority=3)
	public void validateCheckoutProcess() {
	     demoStore.selectComputerOption();
		desktops = demoStore.clickDesktopsBtn();
		buildYourOwnComputer = desktops.clickAddToCartBtn();
		buildYourOwnComputer.selectProcessorValue();
		buildYourOwnComputer.selectRamValue();
		buildYourOwnComputer.selectHddRadioBtn();
		buildYourOwnComputer.selectOsRadioBtn();
		buildYourOwnComputer.selectsoftwareCheckBox();
		buildYourOwnComputer = buildYourOwnComputer.clickAddTocartBtn();
		shoppingCart = buildYourOwnComputer.clickShopingcartLink();
		shoppingCart.clickTermsOfServiceCheckBox();
		checkout = shoppingCart.clickCheckOutBtn();
		checkout.enterFirstName();
		checkout.enterLastName();
		checkout.enterEmail();
		checkout.enterCompanyName();
		checkout.selectCountry();
		checkout.entercityField();
		checkout.enterAddress1Fiels();
		checkout.enterAddress2Fiels();
		checkout.enterPostalCodeField();
		checkout.enterPhoneNumber();
		checkout.enterFaxNumberField();
		checkout=checkout.selectContinueBtn();
		checkout.selectShippingMethodRadioBtn();
		checkout=checkout.selectContinueBtnAfterShippingMethod();
		checkout.selectPaymentMethodRadioBtn();
		checkout=checkout.selectContinueBtnAfterpaymentMethod();
		checkout=checkout.selectContinueBtnAfterpaymentInformation();
		checkout=checkout.selectConfirmBtn();
	String texts=	checkout.showThankyouTextMessage();
	
	Assert.assertEquals(texts, "Thank you","Checkout failed");

	}

}
