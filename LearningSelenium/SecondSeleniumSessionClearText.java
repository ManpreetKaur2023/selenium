package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionClearText {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		wd.manage().window().maximize();
	}

	@Test
	public void validateTextIsClearedFromInputFields() {
		WebElement name = wd.findElement(By.cssSelector("#input-name"));
		WebElement emailLabel = wd.findElement(By.cssSelector("#input-email"));
		WebElement enquiryField = wd.findElement(By.cssSelector("#input-enquiry"));

		name.sendKeys("manpreet");
		emailLabel.sendKeys("manpreet@email.com");
		enquiryField.sendKeys("Testing the element");

		name.clear();
		emailLabel.clear();
		enquiryField.clear();

	}

	@AfterMethod
	public void tearDown() {
		// wd.close();
	}
}
