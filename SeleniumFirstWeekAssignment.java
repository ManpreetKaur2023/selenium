package com.manpreet.LearningSelenium;

import java.util.UUID;

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

		String randomEmail = UUID.randomUUID().toString() + "@example.com"; // To generate unique random emailId.
		String randomPassword = UUID.randomUUID().toString().substring(0, 8); // To generate unique random password.

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
		
		

		enterValues("Manpreet", "Kaur", randomEmail, "12345678", randomPassword, randomPassword);   //Invoking the enterValues() method to find locator and enter values.



		Assert.assertEquals(wd.getTitle(), "Your Account Has Been Created!", "You are on wrong page");

	}

	@Test(priority = 2)
	public void validateLogin() {

		login(); // Invoking the login() method.

	}

	@Test(priority = 3)
	public void validateChangePassword() {

		login(); // Invoking the login() method.

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

		newpassword.sendKeys("Password2");
		confirmPassword.sendKeys("Password2");

		boolean isContinueBtnEnabled = continueBtn.isEnabled();
		Assert.assertTrue(isContinueBtnEnabled, "Continue button is not enabled");
		continueBtn.click();

		WebElement passwordChangeConfirmation = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[text()=' Success: Your password has been successfully updated.']")));

		String passwordChangeConfitmationMessgae = passwordChangeConfirmation.getText();

		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");
		Assert.assertEquals(passwordChangeConfitmationMessgae, "Success: Your password has been successfully updated.",
				"You are on wrong page.");

		logout(); // Invoking the logout() method after changing password.

		login(); // Invoking the login() method after changing the password.

	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

	public void login() {
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
		password.sendKeys("Password2");

		boolean isLoginBtnEnabled = loginBtn.isEnabled();
		Assert.assertTrue(isLoginBtnEnabled, "Login button  is not enabled");
		loginBtn.submit();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");

	}

	public void logout() {
		WebElement myAccount = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Account']")));
		myAccount.click();
		WebElement logout = wd.findElement(By.xpath("(//a[text()='Logout'])[1]"));
		logout.click();
		Assert.assertEquals(wd.getTitle(), "Account Logout", "You are on wrong page");
	}
	
	
	
	

	public void enterValues(String firstNameValue, String lastnameValue, String emailValue, String telephoneValue,
			String passwordValue, String confirmPasswordValue) {
		
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

		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastnameValue);
		email.sendKeys(emailValue);
		telephone.sendKeys(telephoneValue);
		password.sendKeys(passwordValue);
		confirmPassword.sendKeys(confirmPasswordValue);
		subscribeYes.isSelected();
		privacyPolicy.click();

		boolean isContinueBtnEnabled = continueBtn.isEnabled();
		Assert.assertTrue(isContinueBtnEnabled, "Continue button is not enabled");
		continueBtn.submit();
	}
}
