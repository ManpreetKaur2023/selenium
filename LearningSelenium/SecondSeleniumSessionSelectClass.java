package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionSelectClass {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
		wd.manage().window().maximize();
	}

	@Test()
	public void validateSelectCountryByUsingSelectClass() {
		WebElement selectCountryField = wd.findElement(By.cssSelector("select[name='billing.country']"));
		Select sc = new Select(selectCountryField);

		sc.selectByIndex(4);
//		System.out.println(sc.getFirstSelectedOption().getText());
//		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "United Kingdom","United Kingdom is not selected");
//		
		sc.selectByValue("AU");
		System.out.println(sc.getFirstSelectedOption().getText());
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Australia", "Australia is not selected");

		sc.selectByValue("IN");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "India", "India not selected");

		sc.selectByVisibleText("Brazil");
		// System.out.println(sc.getFirstSelectedOption().getText());
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Brazil", "Brazil is not selected");
	}

	@AfterMethod
	public void tearDown() {
		// wd.close();
	}
	
	
}
