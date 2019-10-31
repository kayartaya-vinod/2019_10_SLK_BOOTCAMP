package com.slksoft.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmailerAppTest001 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("http://localhost:8080/phonebook-application");
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
	
	@DataProvider(name = "dataProvider1")
	public Object[][] dataProvider1() {
		return new Object[][] { 
			{ "vinod@vinod.co", "secret" }, 
			{ "shyamkc@example.com", "secret" }, 
			{ "johndoe@example.com", "secret" }, 
			{ "nobody@example.com", "invalidpassword" }, 
			{ "janedoe@example.com", "secret" }, 
			{ "sam@example.com", "secret" }
		};
	}

	@Test(dataProvider = "dataProvider1")
	public void testSuccessfulLogin(String email, String password) {
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("form button.btn.btn-primary")).click();
		
		String anchorText = driver.findElement(By.cssSelector("a[href*=logout]")).getText();
		Assert.assertEquals(anchorText, "Logout");
	}
}







