package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	
	
	private WebDriver driver;
	ElementUtil elementUtil;
	//constructor
	public LoginPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver=driver;
	}

	//By locators or Object Repositories
	
	By email = By.id("input-email");
	By password = By.id("input-password");
	By login = By.cssSelector("input[class='btn btn-primary']");
	By registerLink = By.linkText("Register");
	
	
	//actions
	
	public String getLoginPageTitle() {
		return elementUtil.doWaitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isRegisterLinkExist() {
		return elementUtil.doIsDisplayed(registerLink);
	}
	
	//Page Chaining: 
	public MyAccountPage doLogin(String uName, String pwd) {
		elementUtil.doSendkeys(email, uName);
		elementUtil.doSendkeys(password, pwd);
		elementUtil.doClick(login);
		
		return new MyAccountPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
