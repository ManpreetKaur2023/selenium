package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumSession {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void validateLogin() {
		WebElement emailInput = wd.findElement(By.cssSelector("input[id='input-email']"));
		WebElement passwordInput = wd.findElement(By.cssSelector("input[id='input-password']"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[value='Login']"));

		emailInput.sendKeys("manpreet@email.com");
		passwordInput.sendKeys("Password1");
		loginBtn.click();

		Assert.assertEquals(wd.getTitle(), "My Account", "You are on a wrong page...");

	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

}
