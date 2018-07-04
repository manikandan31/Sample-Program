package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader() {
		try {
		    File src = new File("./Configration/config.property");
		
		    FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception in configuration Utility..."+e.getMessage());
		}
	}
	
	public String getChromePath(){
		
		String chromepath= pro.getProperty("ChromeDriverPath");
		
		System.out.println("Chromepath is"+chromepath);
		
		return chromepath;
	}

}
