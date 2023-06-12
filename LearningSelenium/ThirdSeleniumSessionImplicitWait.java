package com.manpreet.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdSeleniumSessionImplicitWait {
WebDriver wd;
	
	@BeforeMethod
	public void startup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wd.findElement(By.id("onetrust-accept-btn-handler")).click();
		
	}
	
	@Test
	public void validateImplicitWait() {
		
		WebElement selectCountry=wd.findElement(By.cssSelector("select[name='billing.country']"));
		
		Select sc=new Select(selectCountry);
		
		sc.selectByValue("AU");
		 
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Australia", "Australia is not selected");
		
		
		sc.selectByVisibleText("Brazil");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Brazil", "Brazil is not selected");
		
	}
	
	@AfterTest
	public void tearDown() {
		wd.close();
		
	}
}
