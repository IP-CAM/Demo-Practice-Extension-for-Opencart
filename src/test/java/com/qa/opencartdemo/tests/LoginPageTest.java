package com.qa.opencartdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencartdemo.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
    @Description("Login Page title Test")
    @Severity(SeverityLevel.TRIVIAL)
	@Test
	public void loginPageTitleTest() {

		String title = loginpage.getLoginPageTitle();
		System.out.println("The login page title is" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	

	}
    @Description("Forgot password Link Test")
    @Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkTest() {

		Assert.assertTrue(loginpage.isforgotPwdLinkIsDisplayed());
	}
	
    @Description("Forgot password Link Test")
    @Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		accountspage=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountspage.getAccountPageTitle(), Constants.LOGIN_PAGE_TITLE);
	}

}
