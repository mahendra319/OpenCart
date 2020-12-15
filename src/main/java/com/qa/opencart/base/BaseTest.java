package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;

public class BaseTest {

	WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public MyAccountPage myaccountPage;
	
	@Parameters({"browser"}) //this parameter from testng.xml file , browser(parameter) value from testng.xml file
	@BeforeTest
	public void setUp(String browserName) { //browserName is holding parameter for value of browser coming from testng.xml file
		System.out.println("Browser Name is: "+ browserName);
		basePage=new BasePage();
		prop =basePage.init_prop();
		prop.setProperty("browser", browserName); //prop.setProperty() will set new browser value during runtime
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}	
	
	
	//if we want to execute individual class (not from testng.xml file) uncomment below and comment above 
		//OR create separate testng.xml for that specific class then execute
//	@BeforeTest
//	public void setUp() {
//		basePage=new BasePage();
//		prop =basePage.init_prop();
//		driver = basePage.init_driver(prop);
//		loginPage = new LoginPage(driver);
//	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
