package utils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseComponents {

	WebDriver driver;
	public void getScreeShot(WebDriver driver) {
		this.driver	= driver;
		String dir = System.getProperty("user.dir");
		//TakesScreenshot src = ((TakesScreenshot)driver);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,new File(dir+"\\ScreenShots\\"+ driver.getTitle()+"image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void WaitForElementTodisplayed(WebDriver driver ,WebElement element ) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public boolean isElementPresent(WebElement webelement) {
		boolean exists = false;
		try {
			webelement.getTagName();
			exists = true;
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		return exists;
	}

	public void switchToWindow(WebDriver driver) {

		this.driver = driver;
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				//driver.close();
			}

		}
		
	}

	public void switchToParentWindow(WebDriver driver, String parent) {
		
		this.driver = driver;
		//switch to the parent window
		driver.switchTo().window(parent);
	}
}



