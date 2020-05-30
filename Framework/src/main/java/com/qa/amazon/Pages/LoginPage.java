package com.qa.amazon.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.TestBase.*;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Account & Lists') and @class='nav-line-2 ']")
	WebElement Account_signin;
	
	@FindBy(linkText="Sign in")
	////div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner']
	WebElement Siginin;
	
	@FindBy(name="email")
	WebElement username;
	

	@FindBy(id="continue")
	WebElement continue_click;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement SignIn_Submit;
	
	

	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyLoginTitle() {
		return driver.getTitle();
	}
	
	public HomePage SignIn(String uname,String pwd)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(Account_signin).build().perform();
		Siginin.click();
	
		username.sendKeys(uname);
		continue_click.click();
		password.clear();
		password.sendKeys(pwd);
		SignIn_Submit.click();
		return new HomePage();
	}
}
