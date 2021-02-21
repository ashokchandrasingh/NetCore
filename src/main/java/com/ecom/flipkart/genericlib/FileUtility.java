package com.ecom.flipkart.genericlib;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

public class FileUtility {
	
		public String getPropertyKeyValue(String key) throws Throwable  {
			  
			FileInputStream fis = new FileInputStream("./testData/CommonData.properties");
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
		
		return value;
	}


}
