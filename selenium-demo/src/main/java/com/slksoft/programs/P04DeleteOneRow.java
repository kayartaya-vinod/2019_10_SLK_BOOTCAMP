package com.slksoft.programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04DeleteOneRow {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://vinod.co/phonebook-webapp";
		
		driver.get(url);
		
		String xpathExpression = "html//table/tbody/tr[2]//a[@href]/span";
		// String cssSelector = "html table > tbody > tr:nth-child(2) a[href] > span";
		
		WebElement link = driver.findElement(By.xpath(xpathExpression));
		link.click(); // this will bring a popup confirm box (window.confirm of javascript)
		
		// change the focus to the confirm dialog box
		driver.switchTo().alert().accept(); // click the "OK" button, .dismiss() for "CANCEL"
		driver.switchTo().alert().dismiss(); // get rid of the feedback alert
		
		driver.quit();
	}
}
