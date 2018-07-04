package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage2 {
	WebDriver driver;
	@FindBy(id="email") 
	WebElement username;
	
	@FindBy(how=How.XPATH, using="//*[@id='pass']") 
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//*[@id='loginbutton']") 
	WebElement loginbutton;
	
	public LoginPage2(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void LoginFb2(String uid,String pwd){
		
		username.clear();
		username.sendKeys(uid);
		password.sendKeys(pwd);
		loginbutton.click();
	}

}
