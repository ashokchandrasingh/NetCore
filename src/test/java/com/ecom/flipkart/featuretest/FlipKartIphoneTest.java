package com.ecom.flipkart.featuretest;

	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import com.ecom.flipkart.genericlib.BaseClass;
	import com.ecom.flipkart.objectrepo.FlipKartIphonePage;
	import com.opencsv.CSVWriter;

	public class FlipKartIphoneTest extends BaseClass
	{
		@Test
		public void iphonesearchtestcase() throws Throwable
		{
			
			FlipKartIphonePage fp=new FlipKartIphonePage(driver);
			fp.getLoginPopup().click();
			fp.getSearchBOX().sendKeys("iphones less than 40000",Keys.ENTER);
			WebElement searchResult = fp.getContentVal();
			Assert.assertEquals(searchResult.isDisplayed(), true);
			List<WebElement> devicelist = fp.getIphonedevices();
			List<WebElement> pricelist = fp.getIphonePrice();
			List<WebElement> ratingslist = fp.getIphoneRatings();
			
		
			
			String[] header = {"Device Details", "Price", "Ratings"};
			List<String[]> list = new ArrayList<>();
			list.add(0,header);
			for(int i=0;i<devicelist.size();i++)
			{
				String[] row1 = {devicelist.get(i).getText(),pricelist.get(i).getText().substring(1),ratingslist.get(i).getText()};
				list.add(i, row1);
			}
			CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/Iphonedetails3.csv"));
			writecsv.writeAll(list);
			writecsv.close();
		}
			




}
