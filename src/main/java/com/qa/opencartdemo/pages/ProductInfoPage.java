package com.qa.opencartdemo.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencartdemo.utils.ElementUtil;



public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementutil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaDeta = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceDeta = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("//button[text()='Add to Cart']");
	private By sucessMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");

	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	public String getProductHeaderText() {

		return elementutil.doGetText(productHeader);
	}

	public int getproductImagesCount() {

		return elementutil.waitForElementsToBeVisible(productImages, 5).size();
	}

	public Map<String, String> getProductInfo() {

		productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getProductHeaderText());
		getProductMetaData();
		getPriceMetaData();    
        return productInfoMap;
	}
	
	private void getProductMetaData() {
		List<WebElement> metaDatList = elementutil.doGetElements(productMetaDeta);
		for (WebElement e : metaDatList) {

			String text = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}
		
		private void getPriceMetaData() {
			 List<WebElement> metaPriceList=elementutil.doGetElements(productPriceDeta);
	          String Price=metaPriceList.get(0).getText().trim();
	          String ExPrice=metaPriceList.get(1).getText().trim();
	          productInfoMap.put("price", Price);
	          productInfoMap.put("exprice", ExPrice);
			
			
		}
}
