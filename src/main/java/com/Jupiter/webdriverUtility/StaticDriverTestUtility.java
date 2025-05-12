package com.Jupiter.webdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class StaticDriverTestUtility {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new  ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static WebDriver getDriver()
	{
	return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver)
	{
	driver.set(actDriver);
	}
	
	public static void setTest(ExtentTest actTest)
	{
	test.set(actTest);
	}
}
