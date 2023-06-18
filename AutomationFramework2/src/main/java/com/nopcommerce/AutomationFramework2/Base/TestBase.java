package com.nopcommerce.AutomationFramework2.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static WebDriver wd;
	FileInputStream fileInputStream;
	Properties prop;

	public TestBase() {
		prop=new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\Gurwinder\\eclipse-workspace\\AutomationFramework2\\src\\main\\java\\com\\nopcommerce\\AutomationFramework\\Config\\Config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void intialisation() {
		String browserName = prop.getProperty("browser");
switch (browserName) {
case "Chrome":
	wd=WebDriverManager.chromedriver().create();
	
	break;
case "Edge":
	wd=WebDriverManager.edgedriver().create();
	break;
case "Firefox":
	wd=WebDriverManager.firefoxdriver().create();
	break;
default:
	System.out.println("Enter a valid browser name.");
	break;
}


wd.get(prop.getProperty("URL"));
wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

wd.manage().window().maximize();

	}
	
	
	public void tearDown() {
		wd.close();
	}

}
