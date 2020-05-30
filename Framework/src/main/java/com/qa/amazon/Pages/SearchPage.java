package com.qa.amazon.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.amazon.TestBase.TestBase;
import com.qa.amazon.Util.Utilities;

public class SearchPage extends TestBase{

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement search_id;
	
	@FindBy(id="s-result-sort-select")
	WebElement sortby;
	
	
//	@FindBy(xpath="//*[@id='search']/div[1]/div[2]/div/span[4]/div[2]/div[2]/div/span/div/div/span/a/div/img")
//	WebElement link;
	
	public SearchPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void searchText(String text) {
		search_id.sendKeys(text);
		search_id.sendKeys(Keys.ENTER);
	}
	
	public void sortBy()
	{
		Select select=new Select(sortby);
		select.selectByVisibleText("Price: Low to High");
	}
	public String getSearchTitle() {
	return driver.getTitle();
	}
}
