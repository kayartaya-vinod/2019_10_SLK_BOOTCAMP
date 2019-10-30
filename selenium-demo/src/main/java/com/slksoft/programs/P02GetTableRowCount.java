package com.slksoft.programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02GetTableRowCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://vinod.co/phonebook-webapp";
		
		driver.get(url);
		List<WebElement> rows = driver.findElements(By.xpath("html/body//table/tbody/tr"));
		
		System.out.println("There are " + rows.size() + " rows in the table.");
		driver.close(); // closes the browser
	}

}
