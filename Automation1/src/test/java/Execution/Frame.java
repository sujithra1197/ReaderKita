package Execution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frame {
	
	
	 // This will run before the entire suite starts
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setup Suite configurations.");
    }

    // This will run after all tests in the suite finish
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Clean up after all tests in the suite.");
    }
	
@Test(priority = -1)
	public void add() {
		int a = 1;
		int b = 2;
		int c = (a+b);
		System.out.println("add");
	}
@Test(priority = 1)
	public void sub() {
		int a = 5;
		int b = 3;
		int c = (a-b);
		System.out.println("subtract");
	}



@BeforeClass
public void beforeclass() {
	System.out.println("outputbeforeclass");

}

@BeforeMethod
public void b() {
	System.out.println("beforemethod");
}


@AfterClass
public void afterclass() {
	System.out.println("outputafterclass");
}

@AfterMethod
public void a() {
	System.out.println("aftermethod");
}

@Test(priority = 0,groups = {"sanity"})
public void multiply() {
	System.out.println("Multlipy");
}

@Test (groups = {"sanity"})
public void divide() {
	System.out.println("divide");

}
@Test(dependsOnMethods = {"divide"},groups = {"smoke"})
public void addanddivide() {
	System.out.println("addanddivide");

}

}