package com.qa.amazon.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.Pages.HomePage;
import com.qa.amazon.Pages.LoginPage;
import com.qa.amazon.TestBase.TestBase;
import com.qa.amazon.Util.Utilities;

//Added a comment
public class HomepageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	
	
	public HomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialize();
		loginpage=new LoginPage();
		homepage=loginpage.SignIn(Utilities.username,Utilities.password);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
  @Test(priority=1)
  public void getHomepageTitle() {
	  String title=homepage.getHomePageTitle();
	  System.out.println("title of the page is "+title);
	  Assert.assertEquals(title,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more","title mismatch");
  }
  @Test(priority=2)
  public void verifyUserNameLogin() {
	  String user=homepage.verifyUserNameLogin();
	  Assert.assertEquals(user,"Deliver to Archana","user mismatch");
  }
}
