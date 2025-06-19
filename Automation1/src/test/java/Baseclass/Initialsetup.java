package Baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initialsetup {
	public static WebDriver driver;

		public static void BrowserSelect(String option) {
	        
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
		
	public static void loadUrl(String url){
		driver.navigate().to(url);
	}

}
