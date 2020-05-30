package com.qa.amazon.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.amazon.TestBase.TestBase;

public class Utilities extends TestBase {
public static String username=prop.getProperty("username");
public static String password=prop.getProperty("password");
public static long PAGELOAD_TIME=10;
public static long IMPLICIT_TIME=20;
public static String search="Gift for kids";

public static void takeScreenshotAtEndOfTest() throws IOException{
	String destination=System.getProperty("user.dir")+"/Screenshots/failedtests.png";
	File dest=new File(destination);
	TakesScreenshot ts=null;
	File src=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, dest);
}
}
