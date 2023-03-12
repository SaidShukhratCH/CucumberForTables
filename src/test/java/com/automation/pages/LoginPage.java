package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.PropertyReader;

public class LoginPage extends BasePage {

	@FindBy(id = "txtUsername")
	WebElement userNameInput;

	@FindBy(id = "txtPassword")
	WebElement passwordInput;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	 @FindBy((xpath = "//span[@id = 'spanMessage']"))
	// WebElement invalidLoginError;

	public void doLogin(String username, String password) {
		waitForElementToBeClickable(userNameInput, driver);
		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}

	public void verifyInvalidLoginError() {
		Assert.assertTrue("Invalid login error message is not displayed on login page",
				invalidLoginError.isDisplayed());
	}

	public void openSauceWebsite() {
		// Loading url in the browser
		driver.get(PropertyReader.getProperty("application.orange.hrm.url"));
	}

	public void verifyLoginPage() {
		Assert.assertTrue("Username is not displayed on login page", userNameInput.isDisplayed());
		Assert.assertTrue("Password is not displayed on login page", passwordInput.isDisplayed());
	}

}
