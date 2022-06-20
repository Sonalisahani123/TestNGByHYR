package com.hyr.test;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMParameterTest {
	WebDriver driver;

	@Parameters("browserName")
	public void initialiseBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default:
			System.err.println("Browsername is invalid");
			break;

		}
		driver.manage().window().maximize();
	}

	@Parameters("url")
	@Test
	public void launchApp(String url) {

		driver.get(url);
	}

	@Parameters({"username", "password"})
	@Test
	public void enterLoginDetails(String username,String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test
	public void navigateToMyInfo() throws InterruptedException {
		Thread.sleep(20);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
	}

	@Test
	public void verifyMyInfo() {

		boolean actualvalue = driver.findElement(By.id("employee-details")).isDisplayed();
		assertTrue(actualvalue);

	}

	@Test
	public void verifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		System.out.println(element.isDisplayed());
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
