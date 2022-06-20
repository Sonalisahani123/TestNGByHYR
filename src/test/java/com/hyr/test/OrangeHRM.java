package com.hyr.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@Test
	public void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void enterLoginDetails()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void navigateToMyInfo() throws InterruptedException
	{
		Thread.sleep(20);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
	}
	
	@Test
	public void verifyMyInfo()
	{
		driver.findElement(By.id("employee-details")).isDisplayed();
		driver.quit();
	}
	
	@Test
	public void verifyLogin()
	{
		WebElement element=driver.findElement(By.id("welcome"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		driver.quit();
	}

}
