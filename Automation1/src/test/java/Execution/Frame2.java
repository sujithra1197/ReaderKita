package Execution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frame2 {
	@BeforeSuite
	public void beforesuite()
	{
	System.out.println("BeforeSuite");	
	}
	
	@AfterSuite
	public void aftersuite()
	{
	System.out.println("AfterSuite");	
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
	System.out.println("BeforeMethod");	
	}
	
	@AfterMethod
	public void AfterMethod()
	{
	System.out.println("AfterMethod");	
	}
	
	
	
	@Test (groups = {"sanity"})
	public void one()
	{
	System.out.println("Test");	
	}
	
	@Test(priority = -3,dependsOnMethods = {"one"},groups = {"sanity"})
	public void priority1()
	{
	System.out.println("priority1");	
	}
	
	@Test(priority = -2,groups = {"smoke"})
	public void priority2()
	{
	System.out.println("priority2");	
	}
	
	@Test(priority = -1,dependsOnMethods = {"priority2"})
	public void priority3()
	{
	System.out.println("priority3");	
	}
	
	
	
	@BeforeClass
	public void two()
	{
	System.out.println("beforeclass");	
	}
	
	@AfterClass
	public void three()
	{
	System.out.println("afterclass");	
	}
	
	@BeforeTest
	public void beforeTest() {
	    System.out.println("Before Test");
	}
	
	
	@AfterTest
	public void afterTest() {
	    System.out.println("After Test");
	}
	
	
}
