package com.qa.opencartdemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ExcelUtil;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@DataProvider
	public Object[][] getProductData() {
		return ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
	}

	@Test(dataProvider = "getProductData")
	public void productInfoHeaderTest(String productName, String mainProductName) {
		searchResultsPage = accountspage.doSearch(productName);
		productInfoPage = searchResultsPage.SelectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeaderText(), mainProductName);
	}
}
