package com.qa.amazon.TestPages;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.amazon.Pages.LoginPage;
import com.qa.amazon.TestBase.TestBase;
import com.qa.amazon.Util.Utilities;

public class LoginTest extends TestBase {
	LoginPage login;
	//TestBase base=new TestBase();
	
	
	
	public LoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	
	public void setUp() throws IOException {
		intialize();
		login=new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
  @Test(priority=1)
  public void verifyLoginTitleTest() {
	 String title=login.verifyLoginTitle();
	 Assert.assertEquals(title,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more","title mismatch");
  }
  
  @Test(priority=2)
  public void loginToHome()
  {
	 
	  login.SignIn(Utilities.username,Utilities.password);
	  //Assert.assertEquals(loginTitle, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	  
  }
  
}

