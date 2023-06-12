package com.manpreet.LearningSelenium;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class ThirdSeleniunSessionSleepDemo {
	
	WebDriver wd;
	
	@BeforeMethod
	public void startup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
		wd.manage().window().maximize();
		sleep();
		wd.findElement(By.id("onetrust-accept-btn-handler")).click();
		sleep();
	}
	
	@Test
	public void validateSleepCommand() {
		
		WebElement selectCountry=wd.findElement(By.cssSelector("select[name='billing.country']"));
		
		Select sc=new Select(selectCountry);
		
		sc.selectByValue("AU");
		 
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Australia", "Australia is not selected");
		sleep();
		
		sc.selectByVisibleText("Brazil");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Brazil", "Brazil is not selected");
		sleep();
	}
	
	@AfterTest
	public void tearDown() {
		wd.close();
		
	}

	public void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
