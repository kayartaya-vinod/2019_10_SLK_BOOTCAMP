package com.slksoft.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhonebookWebappTest001 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass() called");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass() called");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest() called");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest() called");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod() called");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod() called\n");
	}

	@Test
	public void testAddNewContact() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("testAddNewContact() called");
	}
	
	@Test
	public void testGetRowCount() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("testGetRowCount() called");
	}

	@Test
	public void testDeleteContact() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println("testDeleteContact() called");
	}
}
