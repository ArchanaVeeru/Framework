package com.qa.amazon.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.TestBase.TestBase;
import com.qa.amazon.Util.Utilities;

public class HomePage extends TestBase {

	LoginPage loginpage;
//	String username=prop.getProperty("username");
//	String password=prop.getProperty("password");
	@FindBy(xpath="//span[@id='glow-ingress-line1']")
	WebElement verify_user;
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	// Your Amazon.com
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyUserNameLogin()
	{
		//driver.switchTo().frame(0);
		String user=verify_user.getText();
		return user;
	}
	
	public SearchPage verifySearchPage() {
		return new SearchPage();
	}
}
