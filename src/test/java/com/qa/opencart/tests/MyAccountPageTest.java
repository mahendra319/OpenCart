package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class MyAccountPageTest extends BaseTest{

	
	@BeforeClass
	public void accountPageSetup() {
		myaccountPage =loginPage.doLogin(prop.getProperty("userId").trim(), prop.getProperty("password").trim());

	}
	
	@Test(priority=2)
	public void verifyAccountPageTitleTest() {
		String title =myaccountPage.getAccountPageTitle();
		System.out.println("Account Page Title is: "+title );
		Assert.assertEquals(title, Constants.MYACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void verifyAccountPageUrlTest() {
		String url =myaccountPage.getAccountPageUrl();
		System.out.println("Account Page Url is: "+ url);
		Assert.assertEquals(url, Constants.MYACCOUNT_PAGE_URL);
	}
	
	@Test(priority=3)
	public void verifyAccountPageHeaderValueTest() {
		String headerText =myaccountPage.getAccountPageHeaderText();
		System.out.println("Account Page Header is: "+headerText);
		Assert.assertEquals(headerText, Constants.MYACCOUNT_PAGE_HEADER);
	}
	
	@Test(priority=4)
	public void verifyMyAccountLinkExistTest() {
		Assert.assertTrue(myaccountPage.isMyAccountExist());
	}
	
	@Test(priority=5)
	public void verifySignOutLinkExistTest() {
		Assert.assertTrue(myaccountPage.isSignOutLinkExist());
	}
	
	@Test(priority=6)
	public void clickSignOutTest() {
		myaccountPage.clickSignOut();
	}
	
}
