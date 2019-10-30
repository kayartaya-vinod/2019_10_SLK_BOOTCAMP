package com.slksoft.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01OpenWebsiteInChrome {

	public static void main(String[] args) {
		
		//----> "C:\\users\\slk.WSLK1GFTR4P-09\\Downloads\\chromedriver.exe"
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		
		// this is a variable representing the browser
		WebDriver driver;
		
		// this refers to an object of Chrome browser
		driver = new ChromeDriver();
		
		driver.get("https://vinod.co/phonebook-webapp");
		
		WebElement elem = driver.findElement(By.id("name"));
		elem.sendKeys("Santosh Iyer");
		
		elem = driver.findElement(By.id("email"));
		elem.sendKeys("santosh.k.iyer@example.com");
		
		elem = driver.findElement(By.id("phone"));
		elem.sendKeys("9999988776");
		
		driver.findElement(By.id("btnAdd")).click();
		
		
	}

}
