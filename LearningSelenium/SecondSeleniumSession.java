package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSession {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.get("https://ca.hotels.com/login?&uurl=e3id%3Dredr%26rurl%3D%2F%3Flocale%3Den_CA%26pos%3DHCOM_CA%26siteid%3D300000002");
	}

	@Test
	public void validateIsEnabled() {

		WebElement continueBtn = wd.findElement(By.id("loginFormSubmitButton"));
		WebElement emailInput = wd.findElement(By.id("loginFormEmailInput"));

		boolean isBtnEnabledOrNot = continueBtn.isEnabled();
		Assert.assertFalse(isBtnEnabledOrNot, "Button is enabled");

		emailInput.sendKeys("manpreet@email.com");
		isBtnEnabledOrNot = continueBtn.isEnabled();
		Assert.assertTrue(isBtnEnabledOrNot, "Button is not enabled");

	}

	@AfterMethod
	public void tearDown() {
		// wd.close();
	}

}
