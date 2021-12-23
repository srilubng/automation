package com.utils.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.ReuseComponents;

public class LoginScreen{

	WebDriver driver;

	ReuseComponents reuse = new ReuseComponents();

	@FindBy(how = How.XPATH, using ="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement signInText;

	@FindBy(how = How.XPATH, using ="//span[@class'nav-action-inner']")
	WebElement signInBtn;

	@FindBy(how = How.XPATH, using ="//h1[contains(text(),' Sign-In')]")
	WebElement signInLogo;

	@FindBy(how = How.XPATH, using ="//input[@type='email']")
	WebElement TypeEmail;

	@FindBy(how = How.ID, using ="continue")
	WebElement eltContinue;	

	@FindBy(how = How.XPATH, using ="//input[@type='password']")
	WebElement typePassword;

	@FindBy(how = How.ID, using ="signInSubmit")
	WebElement btnSubmit;

	@FindBy(using="//a[@aria-label=\"Amazon\"]")
	WebElement dashBoardTitle;


	public void verifyPageTitle(WebDriver driver) {
		this.driver = driver;
		String title = driver.getTitle();		
		//assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.inAutomation Problem Statement:",title);
	}

	public void login(String username, String password) {
		signInText.click();		
		signInLogo.isDisplayed();				
		TypeEmail.sendKeys(username);
		eltContinue.click();
		typePassword.sendKeys(password);
		btnSubmit.click();
		//reuse.WaitForElementTodisplayed(driver, dashBoardTitle);				

	}
}







