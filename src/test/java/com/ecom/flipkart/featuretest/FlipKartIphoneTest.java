package com.ecom.flipkart.featuretest;

	import java.io.FileWriter;
	import java.util.ArrayList;
	import java.util.List;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;
	import com.ecom.flipkart.genericlib.BaseClass;
	import com.ecom.flipkart.objectrepo.FlipKartIphonePage;
	import com.opencsv.CSVWriter;

	public class FlipKartIphoneTest extends BaseClass {
		
		@Test
		public void iphoneTest() throws Throwable
		{
				FlipKartIphonePage fkIppage=new FlipKartIphonePage(driver);
				fkIppage.getLoginPopup().click();
				fkIppage.getSearchBOX().sendKeys("iphones less than 40000",Keys.ENTER);
				List<WebElement> devicelist = fkIppage.getIPhoneWithStorage();
				List<WebElement> pricelist = fkIppage.getiPhonePrice();
				List<WebElement> ratingslist = fkIppage.getiPhonePrice();
				
							
				String[] title = {"Price", "Iphone with Storage", "Ratings"};
				List<String[]> list = new ArrayList<>();
				list.add(0,title);
				for(int i=0;i<pricelist.size();i++)
				{
					String[] row = {pricelist.get(i).getText().substring(1),devicelist.get(i).getText(),ratingslist.get(i).getText()};
					list.add(i, row);
				}
				CSVWriter writecsv = new CSVWriter(new FileWriter("./test-output/IphoneList.csv"));
				writecsv.writeAll(list);
				writecsv.close();
			}
				
		
			




}
