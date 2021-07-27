package com.qa.opencartdemo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencartdemo.utils.Constants;
import com.qa.opencartdemo.utils.ElementUtil;


	public class AccountsPage {
		private WebDriver driver;
		private ElementUtil elementutil;

		private By header = By.cssSelector("div#logo h1");
		private By accntSecList = By.cssSelector("div#content h2");
		private By searchField = By.name("search");
		private By searchButton = By.xpath("//div[@id='search']//button[@type='button']");
		private By logout = By.linkText("Logout");
		private By accountsPageLinkList=By.cssSelector("div.list-group a");
		private By footerList=By.xpath("//footer//div[@class='row']//a");

		public AccountsPage(WebDriver driver) {
			this.driver = driver;
			elementutil = new ElementUtil(driver);

		}

		public String getAccountPageTitle() {

			return elementutil.waitForTitleContains(Constants.ACCOUNTS_PAGE_TITLE, 5);

		}

		public String accountsPageHeader() {
			return elementutil.doGetText(header);
		}

		public boolean isLogoutLinkExist() {
			return elementutil.doIsDisplayed(logout);

		}

		public void logout() {

			if (isLogoutLinkExist()) {
				elementutil.doClick(logout);
			}
		}

		public List<String> getAccountList() {

			List<WebElement> acctList = elementutil.waitForElementsToBeVisible(accntSecList, 5);
			List<String> accSecList = new ArrayList<String>();
			for (WebElement e : acctList) {
				accSecList.add(e.getText());
			}
			return accSecList;
		}

		public boolean doSearch() {
			return elementutil.doIsDisplayed(searchField);

		}

		public SearchResultsPage doSearch(String productName) {
			System.out.println("Searching the product:" + productName);
			elementutil.doSendKeys(searchField, productName);
			elementutil.doClick(searchButton);
			return new SearchResultsPage(driver);

		}
		
		public List<String> accountsPageLinksDisplayed() {
			List<WebElement> acclist = elementutil.doGetElements(accountsPageLinkList);
			List<String> acctextList = new ArrayList<String>();

			for (WebElement e : acclist) {
				String text = e.getText();
				if (!text.isEmpty()) {
					acctextList.add(text);
					System.out.println(text);
				}
			}
			return acctextList;
		}
			
		public List<WebElement> footerList() {
		List<WebElement> footerlist=elementutil.doGetElements(footerList);
		for (int i = 1; i < footerlist.size(); i++)  {
			System.out.println(footerlist.get(i).getText());
		}
		return footerlist;
		}


			
		}
