package utils;

import org.openqa.selenium.PageLoadStrategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

	public static WebDriver driver;
	
	
	public static WebDriver getDriver() {
	
		String browser = System.getProperty("browser");
		
		if (browser==null) {
			browser = DataReader.getProperty("browser_type");
		}
		if (driver==null || ((RemoteWebDriver)driver).getSessionId() == null) {
			switch(browser) {
			case "chrome":
				driver = new ChromeDriver();
			break;
			case "firefox":
				driver = new FirefoxDriver();
			break;
			case "chrome-headless":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("-headless");
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver = new ChromeDriver(chromeOptions);
			break;
			case "safari":
				driver = new SafariDriver();
			break;
			default :
				driver = new ChromeDriver();
			
			}
			
		}
	
	
	
		return driver;
	}
	
}
