package com.utils.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.ReuseComponents;

public class SearchForItems {

	WebDriver driver;

	ReuseComponents reuse = new ReuseComponents();

	@FindBy(how = How.XPATH, using ="(//title)[1]")
	WebElement pageTitle;
	
	@FindBy(how = How.XPATH, using ="//div[@class='nav-line-1-container']/span")
	WebElement eltSuccessSign;

	@FindBy(how = How.XPATH, using ="//div[@id='nav-logo']")
	WebElement AmazonLogo;

	@FindBy(how = How.XPATH, using ="//input[@type='text']")
	WebElement Typeserach;
	
	@FindBy(how = How.XPATH, using ="//input[@type='submit']")
	WebElement eltSerach;
	
	@FindBy(how = How.XPATH, using ="(//div[@class='aok-relative' or @class='a-section a-spacing-none']//img)[1]")
	WebElement itemImage;
	
	
	@FindBy(how = How.XPATH, using ="(//div[contains(@class,'a-section a-spacing')]//h2/a)[1]")
	WebElement itemName;
	
	@FindBy(how = How.XPATH, using ="(//span[@class='a-price-whole'])[1]")
	WebElement price;		
	
	@FindBy(how = How.XPATH, using ="//span[@id='productTitle']")
	WebElement viewItemName;		
			
	@FindBy(how = How.XPATH, using ="(//span[contains(@class,'a-price a-text-price') or @class='a-price-whole'])[1]")
	WebElement viewItemPrice;		
			
	@FindBy(how = How.ID, using ="add-to-cart-button")
	WebElement addToCart;		
	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Added to Cart')]")
	WebElement eltAddedToCart;
		
	
			
	public void verifyPageTitle(WebDriver driver) {
		this.driver = driver;
		String title = driver.getTitle();	
		//Amazon Sign In
	//	assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",title);
	}

	public void verifySuccessfulLogin() {
		eltSuccessSign.isDisplayed();
		reuse.isElementPresent(eltSuccessSign);

	}

	public void verifyAmazonLogo() {
		AmazonLogo.isDisplayed();
		reuse.isElementPresent(AmazonLogo);
	}

	public List<String> searchItem(String item,WebDriver driver) throws InterruptedException {
		
		 List<String> stringArray = new ArrayList<String>();
		Typeserach.sendKeys(item);
		eltSerach.click();
		Thread.sleep(3000);
		//reuse.WaitForElementTodisplayed(driver, itemImage);
		itemImage.isDisplayed();
		stringArray.add(itemName.getText());
		stringArray.add(price.getText());
		Thread.sleep(1000);
		return stringArray;
		
	}
	
	public void clickOnItem() throws InterruptedException {
		Thread.sleep(3000);
		itemName.click();
		Thread.sleep(3000);
	}
	
	public void verifyItem(String itemName, String itemPrice) {
		String iName = viewItemName.getText();
		String iPrice = viewItemPrice.getText();
		System.out.println(iName +" = "+iPrice );
		//assertEquals(itemName,iName);
		//assertEquals(itemPrice,iPrice);
		
	}
	
	public void addToCart() throws InterruptedException {
		addToCart.click();
		Thread.sleep(3000);
		eltAddedToCart.isDisplayed();
		}
}
