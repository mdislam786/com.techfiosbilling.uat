package com.TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void SetUp() {
		logger.info("Opening browser");
		initialize();
		loginpage = new LoginPage();

	}

	@Test(priority = 0)
	public void VerifyLogoOfThePage() {
		logger.info("Verifying Logo of the Page");
		boolean logo = loginpage.VerifyLogo();
		Assert.assertTrue(logo);

	}

	@Test(priority = 1)
	public void VerifyTitleOfThePage() {
		logger.info("Verifying title of the Page");
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
	}

	@Test(priority = 2)
	public void VerifyLoginPage() {
		logger.info("Verifying login");
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		boolean dashboard = loginpage.VerifyHomePage();
		Assert.assertTrue(dashboard);
		TestUtil.captureScreenShot(driver, "Login Page");

	}

	@Test(priority = 3)
	public void VerifyErrorMessageWithInvalidUserNamePassword() throws InterruptedException {
		logger.info("Verifying Error Message With Invalid UserName Password");
		loginpage.ErrorMessage(prop.getProperty("InvalidUserName"), prop.getProperty("InvalidPassword"));
		Thread.sleep(5000);
		boolean error = loginpage.VerifyError();
		Assert.assertTrue(error);
		System.out.println("The Error Message is : " + error);
		TestUtil.captureScreenShot(driver, "Verifying Error Message");
	}

	@Test(priority = 4)
	public void VerifyUserInHomePage() {
		logger.info("Verifying User In HomePage");
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		boolean dashboard = loginpage.VerifyHomePage();
		Assert.assertTrue(dashboard);
		TestUtil.captureScreenShot(driver, "Homepage");
	}
	/*
	 * @Test(priority=5) public void takeScreenshot() {
	 * logger.info("Take a ScreenShot"); TestUtil.captureScreenShot(webdriver,
	 * screenShotName);
	 * 
	 * }
	 */

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
