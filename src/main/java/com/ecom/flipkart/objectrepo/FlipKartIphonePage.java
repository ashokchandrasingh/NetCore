package com.ecom.flipkart.objectrepo;

	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;

	public class FlipKartIphonePage {
		WebDriver driver;
		public FlipKartIphonePage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		private WebElement LoginPopUp;
		
		@FindBy(name="q")
		private WebElement searchBOX;
		
		
		 @FindBy(xpath="//span[contains(text(),'Showing 1 – 24 ')]") 
		 private WebElement ContentVal;
		
		
		@FindBy(xpath="//div[@class='_4rR01T']")
		private List<WebElement> IPhoneWithStorage;
		

		public WebElement getLoginPopup() {
			return LoginPopUp;
		}

		public List<WebElement> getIPhoneWithStorage() {
			return IPhoneWithStorage;
		}

		public List<WebElement> getIPhoneRatings() {
			return IPhoneRatings;
		}

		public List<WebElement> getiPhonePrice() {
			return IPhonePrice;
		}

		public WebElement getSearchBOX() {
			return searchBOX;
		}
		
		public WebElement getContentVal() { 
			return ContentVal; 
			}
		
		
		
		@FindBy(xpath ="//span[contains(text(),'Ratings')]")
		private List<WebElement> IPhoneRatings;
		
		@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
		private List<WebElement> IPhonePrice;
		
		public WebElement getPopUp()
		{
			return LoginPopUp;
		}

		

	


}
