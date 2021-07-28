package com.qa.opencartdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementutil;
	

	// By locator

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	 private By registerClick = By.linkText("Register");

	// Constructor of the class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil=new ElementUtil(this.driver);
	}

	// Page Actions
    @Step("Getting Login Page Title")
	public String getLoginPageTitle() {
		return elementutil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 15);
	}
    
    @Step("Forgot password Link")
	public boolean isforgotPwdLinkIsDisplayed() {

		return elementutil.doIsDisplayed(forgotPwdLink);
	}
    
    @Step("Navigating to Register Page")
	public RegistrationPage getRegistrationLink() {	
		
		if(elementutil.doIsDisplayed(registerClick));
		elementutil.doClick(registerClick);
		
		return new RegistrationPage(driver);
		
		}
	
	@Step("login With username: {0} and password {1}")
	public AccountsPage doLogin(String un, String pw) {
		System.out.println("login with :" + un + " : " + pw);
		elementutil.doSendKeys(email, un);
		elementutil.doSendKeys(password, pw);
		elementutil.doClick(loginBtn);
		return new AccountsPage(driver);
		
	}
	
	
	
	
}