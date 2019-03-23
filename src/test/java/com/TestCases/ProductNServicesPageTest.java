package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicesPage;
import com.TestUtil.TestUtil;

public class ProductNServicesPageTest extends TestBase {
	LoginPage loginpage;
	ProductNServicesPage productNServicesPage;
	String SheetName="NewServiceInfo";

	public ProductNServicesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		initialize();
		productNServicesPage = new ProductNServicesPage();
		loginpage = new LoginPage();		
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));		
		
	}
	@DataProvider
	public Object[][] aleena(){
		Object[][] data =TestUtil.getTestData(SheetName);
		return data;
	}

	@Test(dataProvider="aleena")
	public void CreateNewOrder(String ProductName, String SalesPrice, String ItemNumber,String ProductDescription) throws Exception {
		Thread.sleep(5000);
		productNServicesPage.ProductNServices();
		Thread.sleep(5000);
		productNServicesPage.NewService();
		Thread.sleep(5000);
		productNServicesPage.NewOrder(ProductName, SalesPrice, ItemNumber, ProductDescription);		
		Thread.sleep(5000);
		boolean message= productNServicesPage.ValidateAddedSuccessfullyMessage();
		Assert.assertTrue(message);
		TestUtil.captureScreenShot(driver, "Create New Order");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}


