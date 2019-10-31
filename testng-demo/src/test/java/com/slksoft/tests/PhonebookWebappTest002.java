package com.slksoft.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.slksoft.utils.SeleniumUtils;

public class PhonebookWebappTest002 {
	
	WebDriver driver;

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("https://vinod.co/phonebook-webapp/");
	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
	
	private int getContactCount() {
		return driver.findElements(By.xpath("html//table/tbody/tr")).size();
	}
	
	@Test
	public void testAddNewContact() throws IOException {
		
		int contactsBefore = getContactCount();
		driver.findElement(By.id("name")).sendKeys("John Doe");
		driver.findElement(By.id("email")).sendKeys("johndoe@example.com");
		driver.findElement(By.id("phone")).sendKeys("5551230987");
		
		SeleniumUtils.takeScreenshot(driver);
		driver.findElement(By.id("btnAdd")).click();
		SeleniumUtils.takeScreenshot(driver);
		
		int contactsAfter = getContactCount();
		
		Assert.assertEquals(contactsBefore + 1, contactsAfter);
	}
	
	/**
	 * Ensures that without name/email/phone, new contact
	 * will not be added
	 */
	@Test
	public void addContactNegativeTest() {
		int contactsBefore = getContactCount();
		driver.findElement(By.id("name")).sendKeys("John Doe");
		driver.findElement(By.id("email")).sendKeys("johndoe@example.com");
		
		SeleniumUtils.takeScreenshot(driver, "screenshots/beforeAddWithoutPhone.png");
		driver.findElement(By.id("btnAdd")).click();
		driver.switchTo().alert().dismiss();
		// screenshot is allowed only after alert/prompt/confirm is dismissed/accepted
		SeleniumUtils.takeScreenshot(driver, "screenshots/afterAddWithoutPhone.png");
		
		int contactsAfter = getContactCount();
		
		Assert.assertEquals(contactsBefore, contactsAfter);
	}

}









