package com.slksoft.programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03GetFirstRowData {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/vinodkumar/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://vinod.co/phonebook-webapp";
		
		driver.get(url);
		
		// using XPath
		String xpath = "html//table/tbody/tr[1]/td";
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for(WebElement td: list) {
			System.out.println(td.getText());
		}
		
		System.out.println();
		
		// using CSS selector
		// space --> ancestor descendant relationship
		// > (greater than) --> parent child relationship
		// [] --> attribute
		// String cssSelector = "html table > tbody > tr:nth-child(2) > td";
		String cssSelector = "html table > tbody > tr:first-child > td";
		list = driver.findElements(By.cssSelector(cssSelector));
		for(WebElement td: list) {
			System.out.println(td.getText());
		}
		driver.quit();
	}
}






