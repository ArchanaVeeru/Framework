package com.qa.amazon.TestBase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.amazon.Util.Utilities;
import com.qa.amazon.Util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener  eventlistener;
	
	public TestBase() {
		try {
			//ClassLoader loader=Thread.currentThread().getContextClassLoader();
			FileInputStream fis=new FileInputStream("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\Framework\\src\\main\\java\\com\\qa\\amazon\\Config\\Config.properties");
			prop=new Properties();
			prop.load(fis);
			//prop.load(loader.getResourceAsStream("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\Framework\\src\\main\\java\\com\\qa\\amazon\\Config\\Config.properties"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialize() {
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.setBinary("C:\\Users\\ArchanaVeeru\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ArchanaVeeru\\chromedriver");
			driver=new ChromeDriver(options);
		}
		if(browser.equalsIgnoreCase("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ArchanaVeeru\\geckodriver");
			driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		WebEventListener  eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGELOAD_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_TIME,TimeUnit.SECONDS);
		
		driver.get(url);
		
		
		
		
		
		
	}
}
