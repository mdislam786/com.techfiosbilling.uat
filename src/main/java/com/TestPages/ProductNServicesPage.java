package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicesPage extends TestBase {

	@FindBy(xpath = "//span[text()='Products & Services']")
	WebElement ProductNServices;

	@FindBy(xpath = "//a[text()='New Product']")
	WebElement NewProduct;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement ProductName;

	@FindBy(xpath = "//input[@id=\"sales_price\"]")
	WebElement SalesPrice;

	@FindBy(xpath = "//input[@id=\"item_number\"]")
	WebElement ItemNumber;

	@FindBy(xpath = "//textarea[@id=\"description\"]")
	WebElement ProductDescription;

	@FindBy(xpath = "//button[@id=\"submit\"]")
	WebElement ProductSubmit;

	@FindBy(xpath = "//div[@class=\"alert alert-success fade in\"]")
	WebElement ItemAddedSuccessfullyMessage;

	public ProductNServicesPage() {
		PageFactory.initElements(driver, this);
	}

	public void ProductNServices() {
		ProductNServices.click();

	}

	public void NewService() {
		NewProduct.click();

	}

	public boolean ValidateAddedSuccessfullyMessage() {
		return ItemAddedSuccessfullyMessage.isDisplayed();
	}

	public void NewOrder(String productName, String salesPrice, String itemNumber, String productDescription) {
		ProductName.sendKeys(productName);
		SalesPrice.sendKeys(salesPrice);
		ItemNumber.sendKeys(itemNumber);
		ProductDescription.sendKeys(productDescription);
		ProductSubmit.click();

	}

}
