package com.ecom.flipkart.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

/**
 * Base class having all the common test steps required for every testscript
 * @author Ashok Chandra Singh
 *
 */

public class BaseClass {
	
	
	
		public FileUtility fLib = new FileUtility();
		public static WebDriver driver;
			
		
			@BeforeClass()
			public void configBeforeClass() throws Throwable {
				/*Common  Data*/
				String URL  = fLib.getPropertyKeyValue("url");

				String BROWSER  = fLib.getPropertyKeyValue("browser");

				 if(BROWSER.equals("chrome")) {
				    driver = new ChromeDriver();
				 }else if(BROWSER.equals("firefox")) {
					 driver = new FirefoxDriver();
				 }else if(BROWSER.equals("ie")) {
					 driver = new InternetExplorerDriver();
				 }else {
					 driver = new ChromeDriver(); 
				 }
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL);
			}


	}

	


