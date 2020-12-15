package com.qa.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.utils.BrowserOptionsUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author mahen
 *
 */
public class BasePage {

	WebDriver driver;
	Properties prop;
	BrowserOptionsUtil browserOptionsUtil;
	
	/**
	 * this method is used to initialize browser based on give browser name
	 * @param browserName
	 * @return it returns WebDriver
	 */
	public WebDriver init_driver(Properties prop) {
		
		browserOptionsUtil =new BrowserOptionsUtil(prop);
		String browserName=prop.getProperty("browser").trim();
		System.out.println("Browser is: "+ browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(browserOptionsUtil.getChromeBrowserOptions());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(browserOptionsUtil.getFirefoxOptions());
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}else {
			System.out.println("Please enter correct browser name: "+ browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url").trim());
		
		return driver;
	}
	
	/**
	 * this method is used to get properties from config.properties file
	 * @return it returns prop
	 */
	public Properties init_prop() {
		prop = new Properties(); //create empty properties list with no default values
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/opencart/config/config.properties"); //establish connection with config.propertiesfile(i.e. data)
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
