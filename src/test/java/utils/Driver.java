package utils;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
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
			case "sauselab":
				EdgeOptions browserOptions = new EdgeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("120");
				Map<String, Object> sauceOptions = new HashMap<>();
				sauceOptions.put("username", "oauth-savplavunov-439d1");
				sauceOptions.put("accessKey", "247842c5-1807-453f-aadd-f0ef9a9ea6d3");
				sauceOptions.put("build", "10");
				sauceOptions.put("name", "windows10");
				browserOptions.setCapability("sauce:options", sauceOptions);
				
				//Java 20 format
				URL url;
				try {
					url = new URI("https://ondemand.us-west-1.saucelabs.com:443/wd/hub").toURL();
					driver = new RemoteWebDriver(url, browserOptions);
				} catch (MalformedURLException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default :
				driver = new ChromeDriver();
		
			}
			
		}
	
	
	
		return driver;
	}
	
}
