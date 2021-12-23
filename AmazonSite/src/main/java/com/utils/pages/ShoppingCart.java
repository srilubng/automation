package com.utils.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.ReuseComponents;

public class ShoppingCart {

	WebDriver driver;

	ReuseComponents reuse = new ReuseComponents();

	@FindBy(how = How.XPATH, using ="//div[@id='nav-cart-count-container']")
	WebElement cart;
	
	@FindBy(how = How.XPATH, using ="//span[@class='a-list-item']//span[@class='a-truncate-full a-offscreen']")
	WebElement eltitemName;
	
	@FindBy(how = How.XPATH, using ="//p[@class='a-spacing-mini']//span[@class='currencyINR']")
	WebElement eltitemPrice;
	
	@FindBy(how = How.XPATH, using ="//input[@name='proceedToRetailCheckout']")
	WebElement proceed;
	
	
	public void clickItenInCart() throws InterruptedException {
		Thread.sleep(1000);
		cart.click();
		Thread.sleep(2000);
	}
	
	public void verifyItem(String itemName, String itemPrice) {
		String iName = eltitemName.getText();
		String iPrice = eltitemPrice.getText();
		System.out.println(iName +" = "+iPrice );
	//	assertEquals(itemName,iName);
		//assertEquals(itemPrice,iPrice);
		
	}
	
	public void clickProceed() throws InterruptedException {
		Thread.sleep(1000);
		proceed.click();
		Thread.sleep(2000);
	}
	
}
