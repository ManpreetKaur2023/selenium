package com.manpreet.LearningSelenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumPractice {
	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");
		wd = new ChromeDriver();
		wait = new WebDriverWait(wd, 10);
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		wd.manage().window().maximize();

		// wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void validateAfterContactUsTextVisible() {

		WebElement contactUsField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact Us']")));

		contactUsField.click();
		Assert.assertEquals(wd.getTitle(), "Contact Us", "You are on wrong page");

		WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-name")));

		WebElement emailId = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));

		WebElement enquiryField = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-enquiry")));

		name.sendKeys("Manpreet");
		emailId.sendKeys("manpreet@email.com");
		enquiryField.sendKeys("Enquiry for testing purpose");

		WebElement submitBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Submit']")));

		submitBtn.click();

		WebElement afterSubmitText = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']")));

		String afterSubmitTextVisible = afterSubmitText.getText();
		Assert.assertEquals(afterSubmitTextVisible, "Your enquiry has been successfully sent to the store owner!",
				"Text is not visible");

	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

}
