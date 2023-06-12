package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionGetText {
	WebDriver wd;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");

		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		wd.manage().window().maximize();
	}

	@Test
	public void validateIsEmailTextVisible() {

		WebElement emailLabel = wd.findElement(By.xpath("//label[text()='E-Mail Address']"));
		String emailLabelText = emailLabel.getText();
		Assert.assertEquals(emailLabelText, "E-Mail Address", "Email Label text is not visible");

	}

	@AfterMethod
	public void tearDown() {
		// wd.close();
	}
}
