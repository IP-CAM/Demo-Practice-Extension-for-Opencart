package com.qa.opencartdemo.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ExcelUtil;


public class AccountsPageTest extends BaseTest {
	@BeforeClass
	public void accountPageSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	@Test
	public void accountsPageTitleTest() {

		String title = accountspage.getAccountPageTitle();
		System.out.println("The account page title is " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);

	}

	@Test

	public void accPageSecListTest() {
		List<String> actualSecList = accountspage.getAccountList();
		Assert.assertEquals(actualSecList, Constants.getExpectedAccSecList());
	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(accountspage.isLogoutLinkExist());
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accountspage.doSearch());
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "MacBook" }, { "imac" }, { "apple" }

		};

	}

	@Test(dataProvider = "productData")

	public void searchTest(String productName) {
		searchResultsPage = accountspage.doSearch(productName);
		Assert.assertTrue(searchResultsPage.getProductListCount() > 0);

	}

	@DataProvider
	public Object[][] accountpageLinkList() {
		return ExcelUtil.getTestData(Constants.ACCOUNTLISTLINKS_SHEET_NAME);
		
}

	@Test(dataProvider="accountpageLinkList")
	public void accountlinklist(String acctextList) {

		List<String> actualactList=accountspage.accountsPageLinksDisplayed();	
		Assert.assertEquals(actualactList,acctextList);
 

	}

	
}