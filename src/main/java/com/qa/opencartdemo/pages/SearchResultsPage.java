package com.qa.opencartdemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencartdemo.utils.ElementUtil;



public class SearchResultsPage {

	

	private WebDriver driver;
	private ElementUtil elementutil;

	private By searchHeaderName = By.cssSelector("div#content h1");
	private By productResults = By.cssSelector("div.caption a");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elementutil=new ElementUtil(driver);

	}

	public int getProductListCount() {
		int resultCount = elementutil.waitForElementsToBeVisible(productResults, 5).size();
		System.out.println("the search product count: " + resultCount);
		return resultCount;
	}

	public ProductInfoPage SelectProduct(String mainProductName) {
		List<WebElement> searchList =elementutil.waitForElementsToBeVisible(productResults, 5);
		
		for(WebElement e:searchList) {
			String text=e.getText();
			if(text.equals(mainProductName)) {
				e.click();
				break;
				}
		}
			return new ProductInfoPage(driver);
			}
		
		}
		
		
