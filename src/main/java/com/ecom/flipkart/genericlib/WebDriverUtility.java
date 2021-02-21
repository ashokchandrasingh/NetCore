package com.ecom.flipkart.genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * 
 * @author ASHOK CHANDRA SINGH
 *
 */

public class WebDriverUtility {
	
	
	/**
	 * This method is used to switch from one window to another by passing title of the window
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver ,String partialWindowTitle) {
		 
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			if(driver.getCurrentUrl().contains(partialWindowTitle)) {
				break;
			}
		 }
	}
	/**
	 * This method is used to wait for the pageTitle
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForPageTitle(WebDriver driver , String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
		
	}
	/**
	 * This method is used to wait for the element to be clickable
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForTheElementToBeClickable(WebDriver driver , WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	/**
	 * This method is used to accept Alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss Alert pop up
	 * @param driver
	 */
	public void cancellAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * wait for DOM document to be load before finding any element in GUI
	 * @param driver
	 */
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}
}
