package com.hyr.extentreport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCheck {
	
	public static void main(String[] args)
	{
		ExtentReports extentreport=new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("E:\\AutomationWork_WS\\TestNGFrameworkHYR\\report.html");
		extentreport.attachReporter(spark);
		
		
		// by using file
		File file=new File("report1.html");
		ExtentSparkReporter spark1=new ExtentSparkReporter(file);
		extentreport.attachReporter(spark1);
		extentreport.flush();
		
		
	}

}
