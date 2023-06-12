package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionIsSelected {
	WebDriver wd;


	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");
		
		 wd=new ChromeDriver(); 
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}


	@Test
	public void validateIsEnabled() {
		
		WebElement radioBtnNo=wd.findElement(By.xpath("(//input[@name='newsletter'])[2]"));
		boolean isNoBtnSelected=radioBtnNo.isSelected();
	Assert.assertTrue(isNoBtnSelected,"No radio button is not selected");
		
		
		
		
		
		

		
	}


	@AfterMethod
	public void tearDown() {
		//wd.close();
	}

}
