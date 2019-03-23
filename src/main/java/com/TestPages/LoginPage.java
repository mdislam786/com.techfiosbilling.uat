  package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {
	// Page factory
	// We will keep all the locator and methods in this class

	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement Username;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement Password;

	@FindBy(xpath = "//button[@name=\"login\"]")
	WebElement SignInButton;

	@FindBy(xpath = "//img[@class=\"logo\"]")
	WebElement Logo;

	@FindBy(xpath = "//div[@class=\"alert alert-danger fade in\"]")
	WebElement ErrorMessage;
	
	@FindBy(xpath = "//h2[text()='Dashboard ']")
	WebElement Dashboard;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// All action

	public void VerifyLogin(String UN, String PW) {
		Username.sendKeys(UN);
		Password.sendKeys(PW);
		SignInButton.click();
		
	}

	public String VerifyTitle() {
		return driver.getTitle();
	}

	public boolean VerifyLogo() {
		return Logo.isDisplayed();
	}

	public void ErrorMessage(String IUN, String IPW) {
		Username.sendKeys(IUN);
		Username.sendKeys(IPW);
		SignInButton.click();

	}
	public boolean VerifyHomePage() {
		return Dashboard.isDisplayed();
	}
	public boolean VerifyError() {
		 return ErrorMessage.isDisplayed();
		}

}
