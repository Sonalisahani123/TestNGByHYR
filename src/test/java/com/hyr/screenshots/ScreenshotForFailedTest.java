package com.hyr.screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hyr.test.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotForFailedTest extends BaseTest{
	
	@Test
	public void testGoogle() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());

		

	}

	@Test
	public void testFacebook() throws InterruptedException {
		
		driver.get("https://www.facebook.com/45");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("HYR Tutorial", Keys.ENTER);
		Thread.sleep(2000);

		SoftAssert softassert=new SoftAssert();
		// Title assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebookabc";
		softassert.assertNotEquals(actualTitle, expectedTitle, "Title is mismatched");

		// URL assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedURL = "https://www.facebook.com/";
		softassert.assertNotEquals(actualUrl, expectedURL, "URL is mismatched");

		// Text assertion
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "";
		softassert.assertEquals(actualText, expectedText, "Text is mismatched");
		softassert.assertAll();

	}
	
	@Test
	public void testORangeHRM()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).click();
	Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	}
	
	
	
	

}
