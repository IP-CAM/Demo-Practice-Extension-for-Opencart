package com.qa.opencartdemo.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass

	public void registrationSetup() {
		registrationpage = loginpage.getRegistrationLink();
	}

	public String getRandomMail() {

		Random randomGenerator = new Random();
		String email = "testnew" + randomGenerator.nextInt(1000) + "@gmail.com";
		return email;

	}

	@Test
	public void getRegistrationPageTitle() {

		String title = registrationpage.getRegistrationPageTitle();
		System.out.println("The Registration Page title is:" + title);
		Assert.assertEquals(title, Constants.REGISTER_PAGE_TITLE);

	}

	@DataProvider
	public Object[][] registrationData() {
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}

	@Test(dataProvider = "registrationData")
	public void doRegistrationDetails(String firstname, String lastname, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(registrationpage.registerPageDetails(firstname, lastname, getRandomMail(), telephone,
				password, subscribe));
	}

}