package com.manpreet.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

public class SeleniumFirstWeekAssignment {

	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void startup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromeDrivers\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wait = new WebDriverWait(wd, 10);
		wd.manage().window().maximize();

	}

	@Test(priority = 1)
	public void validateSignUp() {

		WebElement myAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));

		boolean isMyAccountFieldEnabled = myAccount.isEnabled();
		Assert.assertTrue(isMyAccountFieldEnabled, "My Account field is not enabled");
		myAccount.click();

		WebElement register = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Register'])[1]")));
		boolean isRegistertFieldEnabled = register.isEnabled();
		Assert.assertTrue(isRegistertFieldEnabled, "Register field is not enabled");
		register.click();

		Assert.assertEquals(wd.getTitle(), "Register Account", "You are on wrong page");

		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-firstname")));

		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-lastname")));

		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-email")));

		WebElement telephone = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-telephone")));

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-password")));

		WebElement confirmPassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-confirm")));

		WebElement subscribeYes = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='newsletter']) [1]")));

		WebElement privacyPolicy = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));

		WebElement continueBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));

		firstName.sendKeys("ManpreetKaur");
		lastName.sendKeys("Saini");
		email.sendKeys("manpreet100@email.com");
		telephone.sendKeys("123456789");
		password.sendKeys("Password1");
		confirmPassword.sendKeys("Password1");
		subscribeYes.isSelected();
		privacyPolicy.click();

		boolean isContinueBtnEnabled = continueBtn.isEnabled();
		Assert.assertTrue(isContinueBtnEnabled, "Continue button is not enabled");
		continueBtn.submit();

		Assert.assertEquals(wd.getTitle(), "Your Account Has Been Created!", "You are on wrong page");

	}

	@Test(priority = 2)
	public void validateLogin() {
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		WebElement myAccount = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Account']")));
		boolean isMyAccountFieldEnabled = myAccount.isEnabled();
		Assert.assertTrue(isMyAccountFieldEnabled, "My Account field is not enabled");
		myAccount.click();

		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Login']")));

		boolean isLoginFieldEnabled = login.isEnabled();
		Assert.assertTrue(isLoginFieldEnabled, "Login field is not enabled");
		login.click();
		Assert.assertEquals(wd.getTitle(), "Account Login", "You are on wrong page");

		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-email")));

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-password")));

		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));

		email.sendKeys("manpreet222@email.com");
		password.sendKeys("Password1");

		boolean isLoginBtnEnabled = loginBtn.isEnabled();
		Assert.assertTrue(isLoginBtnEnabled, "Login button  is not enabled");
		loginBtn.submit();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");

//		WebElement logout=wd.findElement(By.xpath("(//a[text()='Logout'])[1]"));
//		logout.click();
//		Assert.assertEquals(wd.getTitle(), "Account Logout","You are on wrong page");
//		

	}

	@Test(priority = 3)
	public void validateChangePassword() {
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/account");

		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-email")));

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-password")));

		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));

		email.sendKeys("manpreet222@email.com");
		password.sendKeys("Password1");
		boolean isLoginBtnEnabled = loginBtn.isEnabled();
		Assert.assertTrue(isLoginBtnEnabled, "Login button  is not enabled");
		loginBtn.submit();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");

		WebElement changePassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Change your password']")));

		boolean isChangePasswordFieldEnabled = changePassword.isEnabled();
		Assert.assertTrue(isChangePasswordFieldEnabled, "Change password field is not enabled");
		changePassword.click();
		Assert.assertEquals(wd.getTitle(), "Change Password", "You are on wrong page");

		WebElement newpassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-password")));

		WebElement confirmPassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-confirm")));

		WebElement continueBtn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='submit']")));

		newpassword.sendKeys("Password1");
		confirmPassword.sendKeys("Password1");

		boolean isContinueBtnEnabled = continueBtn.isEnabled();
		Assert.assertTrue(isContinueBtnEnabled, "Continue button is not enabled");
		continueBtn.click();

		WebElement passwordChangeConfirmation = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[text()=' Success: Your password has been successfully updated.']")));

		String passwordChangeConfitmationMessgae = passwordChangeConfirmation.getText();

		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");
		Assert.assertEquals(passwordChangeConfitmationMessgae, "Success: Your password has been successfully updated.",
				"You are on wrong page.");

	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

}
