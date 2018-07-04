package com.package1;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.facebook.pages.LoginPage;
import com.facebook.pages.LoginPage2;

import Utility.ConfigReader;


public class Class10 {
	public static WebDriver driver;
	public static SoftAssert softassert;
	public static Logger logger;
	@Test(priority=1)
	public static void method1() throws InterruptedException{
		
		ConfigReader config = new ConfigReader();
		
		String chromepath=config.getChromePath();
		
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium\\Software\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver",chromepath);
/*		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--enable-automation");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
	*/	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		softassert= new SoftAssert();
		logger= Logger.getLogger("Class10");
		String log4Jconfigpath = System.getProperty("user.dir")+"/src/test/resources/log4j.properties";
		//String log4Jconfigpath = System.getProperty("user.dir")+"/src/test/java/log4j.properties";
		PropertyConfigurator.configure(log4Jconfigpath);
		System.out.println("In Method 1");
		logger.info("Inside method 1 logger");
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.loginFacebook("xxxxxxx","wwwwwwwwww");
		logger.info("Inside Loginpage 1 logger");

		//driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).click();
		
		
		
		//isElementPresent(By.xpath("//*[@id='not_me_link']"));
		
		WebElement element= driver.findElement(By.xpath("//*[@id='not_me_link']"));
		
		softassert.assertTrue(element.isDisplayed(), "Error in Assert 1----------");
		softassert.assertAll();
		
	}

	@Test(priority=2)//,dependsOnMethods={"method1"})
	public static void  method2() throws InterruptedException{
		System.out.println("In Method 2");
	    Thread.sleep(1000);
		//logger= Logger.getLogger("Class10");
		logger.info("Inside method 2 logger ");
		LoginPage2 loginpage2=PageFactory.initElements(driver, LoginPage2.class);
		loginpage2.LoginFb2("QQQQQQ", "EEEEEE");
		
		
		System.out.println("Successfull");
	}
	
	}

