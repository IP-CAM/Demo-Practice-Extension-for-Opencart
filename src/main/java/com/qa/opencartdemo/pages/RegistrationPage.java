package com.qa.opencartdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ElementUtil;



public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil elementutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telePhone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confpassword = By.id("input-confirm");
	private By agree = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'] )[position ()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'] )[position ()=2]/input[@type='radio']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLinkText = By.linkText("Register");
	

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getRegistrationPageTitle() {
		return elementutil.waitForTitleIs(Constants.REGISTER_PAGE_TITLE, 5);
	}

	public boolean registerPageDetails(String firstname, String lastname, String Email,String telephone, String password,
			String subscribe) {
		elementutil.doSendKeys(this.firstName, firstname);
		elementutil.doSendKeys(this.lastName, lastname);
		elementutil.doSendKeys(this.email, Email);
		elementutil.doSendKeys(this.telePhone, telephone);
		elementutil.doSendKeys(this.password, password);
		elementutil.doSendKeys(this.confpassword, password);

		if (subscribe.equals("yes")) {
			elementutil.doClick(subscribeYes);
		} else {
			elementutil.doClick(subscribeNo);
		}

		elementutil.doClick(agree);
		elementutil.doClick(continueButton);
		String messg=elementutil.isElementVisible(successMessg, 5).getText();
		
		if(messg.contains(Constants.REGISTER_SUCCESS_MESSG)) {
			elementutil.doClick(logoutLink);
			elementutil.doClick(registerLinkText);
			
			return true;
		}
		
		return false;
	}
	
	
}
