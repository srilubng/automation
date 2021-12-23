package shopping;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.utils.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReuseComponents;

public class PurchaseProduct {

	WebDriver driver;
	String url;
	String dir;
	ReuseComponents reuse = new ReuseComponents();
	String itemName;
	String itemPrice;
	String username;
	String password;
	


	//Initiate Object for Page classes
	LoginScreen loginPage;
	SearchForItems search;
	ShoppingCart cart;
	

	//Get url from property file
	@Test(priority =1)
	public void getUrl() throws IOException {

		String dir = System.getProperty("user.dir");
		String propertyFilePath = dir+"\\src\\main\\java\\utils\\url_config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyFilePath);		
		prop.load(fis);
		url = prop.getProperty("url"); 
		username = prop.getProperty("username"); 
		password = prop.getProperty("password"); 
		System.out.println(url);
	}

	@Test(priority =2)

	public void setUpWebDriver() {		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
	}
	
	@Test(priority =3)
	public void LaunchLogin(){	
		
		driver.get(url);
		driver.manage().window().maximize();
		loginPage = PageFactory.initElements(driver, LoginScreen.class);	
		loginPage.verifyPageTitle(driver);
		//reuse.getScreeShot(driver);
		loginPage.login(username,password );
	}
	
	
	@Test(priority =4)
	public void searchForItem() throws InterruptedException {
		
		
		search =  PageFactory.initElements(driver, SearchForItems.class);
		search.verifyPageTitle(driver);
		System.out.println("searchForItem");
		search.verifyAmazonLogo();
		search.verifySuccessfulLogin();
		List<String> itemDetails_1= search.searchItem("Smart watch",driver);
		itemName = itemDetails_1.get(0);
		itemPrice = itemDetails_1.get(1);
		System.out.println(itemName +" - "+ itemPrice );
		search.clickOnItem();	
		
		reuse.switchToWindow(driver);
		
		search.verifyItem(itemName, itemPrice);
		search.addToCart();
		
		//	Add 2nd Item 	
		List<String> itemDetails_2= search.searchItem("pen drive",driver);
		String itemName1 = itemDetails_2.get(0);
		String itemPrice2 = itemDetails_2.get(1);
		System.out.println(itemName1 +" - "+ itemPrice2 );
		search.clickOnItem();	
		reuse.switchToWindow(driver);
		search.verifyItem(itemName, itemPrice);
		search.addToCart();
		
		
	}
	
	@Test(priority =5)
	public void verifyCart() throws InterruptedException {	
		
		cart =  PageFactory.initElements(driver, ShoppingCart.class);
		
		cart.clickItenInCart();
		cart.verifyItem(itemName,itemPrice);
		cart.clickProceed();
		
	}
	

	@Test(priority =6)
	public void click() {
		driver.quit();
	}
}
