package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class MyAccountPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	//constructor
	public MyAccountPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver=driver;
	}
	
	//By locators
	By header = By.tagName("h1");
	By myAccount = By.xpath("//span[text()='My Account']");
	By logout = By.linkText("Logout");
	By logoutContinueBtn = By.linkText("Continue");
	
	
	
	//Actions
	
	public String getAccountPageTitle() {
		return elementUtil.doWaitForTitlePresent(Constants.MYACCOUNT_PAGE_TITLE, 10);
	}
	
	public String getAccountPageUrl() {
		return elementUtil.doGetCurrentUrl();
	}
	
	public boolean isMyAccountExist() {
		return elementUtil.doIsDisplayed(myAccount);
	}
	
	public String getAccountPageHeaderText() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public boolean isSignOutLinkExist() {
		return elementUtil.doIsDisplayed(logout);
	}
	
	public void clickSignOut() {
		elementUtil.doClick(logout);
		elementUtil.doWaitForElementClickableAndClickWhenReady(logoutContinueBtn, 10);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
