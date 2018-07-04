package com.facebook.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.package1.Class10;

public class LoginPage extends Class10 {
	
	//WebDriver driver;
	//logger= Logger.getLogger(Class10.class);
	By username = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='pass']");
	By button = By.xpath("//*[@value='Log In']");
	


	public LoginPage(WebDriver driver){
		System.out.println("driver2=" + driver);
		logger.info("Logger Inside Login Page class method1 ");
		this.driver=driver;
	}

	public void loginFacebook(String userid, String pwd){
		System.out.println("driver3=" + driver);
		logger.info("Logger Inside Login Page class method2 ");
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(button).click();
		
		
	}
}
