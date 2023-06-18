package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class BuildYourOwnComputer extends TestBase {
	

	
	@BeforeMethod
	public void setUp() {
		intialisation();
	}
	

	
	@FindBy(xpath = "//select[@name='product_attribute_1']")
	private WebElement processor;
	
	
	
	
	
	@FindBy(xpath = "//select[@name='product_attribute_2']")
	private WebElement ram;
	
	
	
	@FindBy(xpath = "(//input[@name='product_attribute_3'])[1]")
	private WebElement hddRadioBtn;
	
	
	
	@FindBy(xpath = "(//input[@name='product_attribute_4'])[1]")
	private WebElement osRadioBtn;
	
	@FindBy(xpath = "(//input[@name='product_attribute_5'])[2]")
	private WebElement softwareCheckBox;
	
	@FindBy(css = "div.add-to-cart-panel button")
	private WebElement addToCartBtn;
	
	@FindBy(css = "div.bar-notification  p")
	private WebElement addToCartText;
	
	@FindBy(css = "div.bar-notification  a")
	private WebElement shoppingCartLink;
	
	public void selectProcessorValue() {
		Select sc = new Select(processor);
		sc.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
	}
	
	public void selectRamValue() {
		Select sc = new Select(ram);
		sc.selectByValue("4");
	}
	
	public void selectHddRadioBtn() {
		hddRadioBtn.isSelected();
	}
	
	public void selectOsRadioBtn() {
		osRadioBtn.isSelected();
	}
	
	public void selectsoftwareCheckBox() {
		softwareCheckBox.click();
	}
	
	public BuildYourOwnComputer clickAddTocartBtn() {
		addToCartBtn.click();
		return new BuildYourOwnComputer();
	}
	
	
	
	
	
	public ShoppingCart clickShopingcartLink() {
		shoppingCartLink.click();
		return new ShoppingCart();
		
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
