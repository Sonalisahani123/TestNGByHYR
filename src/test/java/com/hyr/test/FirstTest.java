package com.hyr.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void testGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());

		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void testFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
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

		driver.quit();
		softassert.assertAll();

	}
}
