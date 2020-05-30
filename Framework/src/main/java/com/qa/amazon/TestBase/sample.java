package com.qa.amazon.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

public class sample extends TestBase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\Framework\\src\\main\\java\\com\\qa\\amazon\\Config\\Config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));

	}

}
