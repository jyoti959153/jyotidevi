
package com.Jupiter.Listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.generic.webdriverutility.StaticDriverTestUtility;

import BaseClass1.BaseTest1;

public class ListenerImplementClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	 public ExtentTest test;
	 String localTime = new Date().toString().replace(":", "_").replace(" ", "_");
	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		// here we are configuring the extent report by using ExtentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+localTime+".html");
		spark.config().setDocumentTitle("Crm suite results");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		// add enivironment inforamation in extent report and create test in extent
		// report
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window");
		report.setSystemInfo("browser", "chrome");

	}

	@Override
	public void onFinish(ISuite suite) {
    System.out.println("report backup");
    report.flush();

	}

	@Override
	
	public void onTestFailure(ITestResult result) {// here we are getting runtimeevent(failure) in result
		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseTest1.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+localTime);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"FAILED");
		test.log(Status.FAIL, result.getThrowable());//it will give exception in extent report
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	    test = report.createTest(result.getMethod().getMethodName());
	    test.log(Status.INFO, result.getMethod().getMethodName()+"STARTED");
	    StaticDriverTestUtility.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	    test.log(Status.PASS, result.getMethod().getMethodName()+"SUCCESS");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getThrowable());//it will give exception in extent report
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
