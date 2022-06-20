package com.hyr.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static  String ss_subFolderName;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(String fileName)
	{
		
		  if(ss_subFolderName == null) { 
			  LocalDateTime myDateObj = LocalDateTime.now();
			    System.out.println("Before formatting: " + myDateObj);
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");

			     ss_subFolderName = myDateObj.format(myFormatObj);
			   // System.out.println("After formatting: " + formattedDate);
		  
		  }
		 
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./ScreenShot/"+ ss_subFolderName + "/" + fileName);
		try {
			FileUtils.copyFile(sourceFile,destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println("SS taken successfully");
	}

}
