package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.TakesScreenshot;





import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public  void BrowserSelect(String option) {

		switch(option) {

		case "Chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome Browser is Launched");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge Browser is Launched");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("FireFox Browser is Launched");
			break;

		}

	}
	
	// book close and relaunch
	
	public static void close(){
		driver.close();
		
	}
	
    // Function to highlight an element using JavaScriptExecutor
	
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Applying a style change to highlight the element
        js.executeScript("arguments[0].style.border='3px solid red'", element);
       
    }
      //Extend Report
    
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;


    public static void extentStart(String name){
        // Specify the folder path where you want to save the extent report
        String folderPath =  path + "/Epubreport/";

        // Create folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        
        // Specify the file path within the folder
        String reportPath = folderPath + name + ".html";

        // Initialize ExtentHtmlReporter and ExtentReports
        htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static void extentEnd() {
        extent.flush();
    }
    
    
    public static String path1 = System.getProperty("user.dir");
    public static void testCase(String tc,String info1,String pass1 ) throws IOException,InterruptedException  {
        ExtentTest test1 = extent.createTest(tc);
        test1.info(info1);
        test1.pass(pass1);
//                test1.addScreenCaptureFromPath(path+"/CLAuthorScreenshot/"+sclink1+".png");
//                test1.addScreenCaptureFromPath(path+"/CLAuthorScreenshot/"+sclink2+".png");
    }
    public static void testCase1(String tc,String pass1, String sclink1,String sclink2 ) throws IOException,InterruptedException  {
        ExtentTest test1 = extent.createTest(tc);
//        test1.info(info1);
        test1.pass(pass1);
                test1.addScreenCaptureFromPath(path+"/EpubScreenshot/"+sclink1+".png");
                test1.addScreenCaptureFromPath(path+"/EpubScreenshot/"+sclink2+".png");
    }
    
    public static void testCase2(String tc,String pass1, String sclink1 ) throws IOException,InterruptedException  {
        ExtentTest test2 = extent.createTest(tc);
        test2.pass(pass1);
                test2.addScreenCaptureFromPath(path+"/EpubScreenshot/"+sclink1+".png");
                
    }
    
    public static void failTestCase(String tc,String info1 , String fail) {
        ExtentTest test2 = extent.createTest(tc);
        test2.info(info1);
        test2.fail(fail);
    }
    
    public static void failTestCase(String tc,String info1,String fail, String sclink1 ) throws IOException,InterruptedException  {
        ExtentTest test1 = extent.createTest(tc);
        test1.info(info1);
        test1.fail(fail);
                test1.addScreenCaptureFromPath(path+"/EpubScreenshot/"+sclink1+".png");
                
    }
    //Screenshot
    
    public static void ScreenShot(WebDriver driver, String name) {
        // Specify the folder path where you want to save the extent report
        String folderPath = path + "/EpubScreenshot/";

        // Create folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File des = new File(folderPath + name + ".png");
            FileHandler.copy(src, des);
            //            System.out.println("Screenshot saved at: " + des.getAbsolutePath());
        } catch (IOException e) {
            //            e.printStackTrace();
            System.err.println("Error occurred while taking a screenshot: " + e.getMessage());
        }
    }


    
    
    public static void testCase(String tc,String info1,String pass1, String sclink1,String sclink2 ) throws IOException,InterruptedException  {
        ExtentTest test1 = extent.createTest(tc);
        test1.info(info1);
        test1.pass(pass1);
                test1.addScreenCaptureFromPath(path+"/CLReaderReport/"+sclink1+".png");
                test1.addScreenCaptureFromPath(path+"/CLReaderReport/"+sclink2+".png");
    }
  
    
    // Its used to drag a line drag in elements
    
    public static void moveToGivenPoint(WebElement from, int x, int y) {
		Actions action = new Actions(driver);
		action.clickAndHold(from);
		action.moveByOffset(x, y).build().perform();
		action.click();
	}
    
    //Its a normal click we can use this to click an element
    
    
    public static void clickElementUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to click the element
        js.executeScript("arguments[0].click();", element);
    }
	// URL launch 
	
	public void loadUrl(String url){
		driver.navigate().to(url);

	}
	//Wait for xpath

	public static void explicitWait(WebElement xpath,int abc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(abc));
		wait.until(ExpectedConditions.elementToBeClickable(xpath));
	}
	
	// Adding notes font size increase and decrease
	
	public static void moveToGivenPoint1(WebElement from, int x, int y) {
        Actions action = new Actions(driver);
        action.clickAndHold(from);
        action.moveByOffset(x, y).build().perform();
        action.click();
	}
	
	//Window handeling
	
	public static void lastWindow() {
		Set<String> parentwindow =driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		for(String windows: parentwindow) {
			list.add(windows);
		}
		driver.switchTo().window(list.get(list.size()-1));
	}
	public static void windowHandles(int window) {
		Set<String> parentwindow =driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		for(String windows: parentwindow) {
			list.add(windows);
		}
		driver.switchTo().window(list.get(window));
	}
	
	 // Scroll functionality in info
	
	public static void executeScripScroll(WebElement scrl) {
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",scrl);
	}
	
	// page scroll down
	
	public static void scrollDown() {
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,1000)");
	}
	// page scroll up
	
	public static void scrollUp() {
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,-1000)");
	}
	
	//To use credentials dynamically
	
	public static String path = System.getProperty("user.dir");
	public static String readProperty(String Key) throws IOException {
		File file = new File(path+"/CLReader.properties/");
		FileInputStream fis = new FileInputStream(file);
		Properties po = new Properties();
		po.load(fis);
		String value = po.getProperty(Key);
		return value;
	}
	
	
}
