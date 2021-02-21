package com.ecom.flipkart.genericlib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author ASHOK CHANDRA SINGH
 *
 */

public class WebDriverUtility {
	/**
	 * using this method we will be able to select drop down by visible text
	 * @param element
	 * @param visibleText
	 */
	public void selectBy(WebElement element , String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * using this method we will be able to select drop down by index
	 * @param element
	 * @param data
	 */
	public void selectBy(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to switch from one window to another by passing title of the window
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver ,String partialWindowTitle) {
		 //switchTo new Window
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
 * This Method is used to wait for the element to be available
 * @param driver
 * @param elemnetXpath
 * @throws InterruptedException
 */
	public void waitForTheElementXpath(WebDriver driver , String elemnetXpath) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 driver.findElement(By.xpath(elemnetXpath)).isEnabled();
				 break;
			 }catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	/**
	 * This method is used to perform mouse actions on the element
	 * @param driver
	 * @param element
	 */
	public void moveMouseToElement(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform right click action on the element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClick(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
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



}
