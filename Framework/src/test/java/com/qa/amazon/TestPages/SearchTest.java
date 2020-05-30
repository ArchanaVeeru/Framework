package com.qa.amazon.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.Pages.HomePage;
import com.qa.amazon.Pages.LoginPage;
import com.qa.amazon.Pages.SearchPage;
import com.qa.amazon.TestBase.TestBase;
import com.qa.amazon.Util.Utilities;

public class SearchTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	SearchPage searchPage=new SearchPage();
	
	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialize();
		loginpage=new LoginPage();
		searchPage=new SearchPage();
		homepage=loginpage.SignIn(Utilities.username,Utilities.password);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
  @Test(priority=1)
  public void searchBox() {
	 // driver.switchTo().frame(0);
	  searchPage.searchText(Utilities.search);
	  searchPage.sortBy();
	  String title=searchPage.getSearchTitle();
	  System.out.println("title is "+ title);
	  Assert.assertEquals(title,"Amazon.com : Gift for kids","searchPage title mismatch");
	  
  }
  
  @Test(priority=2,enabled=false)
  public void sortBy()
  {
	  searchPage.sortBy();
  }
  
  @Test(priority=3,enabled=false)
  public void getSearchTitle() {
	  String title=searchPage.getSearchTitle();
	  System.out.println("title is "+ title);
	  Assert.assertEquals(title,"Amazon.com : Gift for kids","searchPage title mismatch");
  }
}
