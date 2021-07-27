package com.qa.opencartdemo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencartdemo.factory.DriverFactory;
import com.qa.opencartdemo.pages.AccountsPage;
import com.qa.opencartdemo.pages.LoginPage;
import com.qa.opencartdemo.pages.ProductInfoPage;
import com.qa.opencartdemo.pages.RegistrationPage;
import com.qa.opencartdemo.pages.SearchResultsPage;



public class BaseTest {

	public WebDriver driver;
	public DriverFactory driverFactory;
	public Properties prop;
	public LoginPage loginpage;
	public AccountsPage accountspage;
	public RegistrationPage registrationpage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage productInfoPage;
	public SoftAssert softAssert = new SoftAssert();

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setUp(String browserName, String browserVersion) {

		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();

		if (browserName != null) {

			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
		}
		driver = driverFactory.init_driver(prop);
		loginpage = new LoginPage(driver);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}