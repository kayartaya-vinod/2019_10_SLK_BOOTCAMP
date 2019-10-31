package com.slksoft.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class SeleniumUtils {
	static int counter = 1;
	
	private SeleniumUtils() {
	}

	public static void takeScreenshot(WebDriver driver) {
		String path = "screenshots/screenshot_" + System.currentTimeMillis() + "_" + (counter++) + ".png";
		takeScreenshot(driver, path);
	}

	public static void takeScreenshot(WebDriver driver, String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tmpFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmpFile, new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e); // convert a checked exception into an unchecked exception
		}
	}
}
