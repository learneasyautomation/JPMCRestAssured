package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPriorityExample {
	
	
	@BeforeTest
	public void beforeTests() {
		System.out.println("Inside Before Tests");
	}
	
	@Test
	public void testOne() {
		System.out.println("Inside Test One");
		Assert.assertEquals("Ameya", "Ameya");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Inside Test Two");
	}
	
	@BeforeMethod
	public void beforeEachTestMethod() {
		System.out.println("Inside Before Each test Method");
	}
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Inside SetUp");
	}

	
	@AfterMethod
	public void afterEachTestMethod() {
		System.out.println("Inside After Each test Method");
	}
}
