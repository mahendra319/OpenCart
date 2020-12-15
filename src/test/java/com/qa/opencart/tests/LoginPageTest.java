package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{

	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title =loginPage.getLoginPageTitle();
		System.out.println("Login Page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyRegisterLinkTest() {
		boolean flag =loginPage.isRegisterLinkExist();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("userId"), prop.getProperty("password"));
	}
	
	
	
	
	
}
