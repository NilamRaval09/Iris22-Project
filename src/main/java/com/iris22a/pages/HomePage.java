package com.iris22a.pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class HomePage {
	private static final Logger log = Logger.getLogger(HomePage.class);
	
	//pagefactory
	@CacheLookup
	@FindBy(xpath="//div[@class='desktop-navLink']/a[@href=\"/shop/men\"]")
	public WebElement menMenu;
	
	//@FindBy
	//public WebElement desktop-header-cnt; //here no need to pass locator in the @FindBy, we can directly mention id or name attribute values, only id & name are allowed
	//in this case desktop-header-cnt will not work bacause of -.
	
	
	@FindBy(xpath="//a[@href=\"/men-tshirts\"]")
	public WebElement menTShirt;
	
	
	/*public HomePage() {//initialization using constructor
		menMenu = UIKeyword.driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[@href=\"/shop/men\"]"));
		menTShirt = UIKeyword.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"));
		
	}*/
	
	@FindBy(xpath="//li[@class='desktop-oddColumnContent'][1]/descendant::a[contains(text(),'Casual Shirts')]")
	public WebElement casualShirts;
	
	@FindBy(xpath="//input[@class='desktop-searchBar']")
	public WebElement searchComponent;
	
	@FindBy(xpath="//h3[@class='product-brand']")
	public List<WebElement> productTexts;
	
	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
		
	}
	
	
	public void hoverOnMenMenu() {
		UIKeyword.mouseMove(menMenu);

	}
	public void clickOnMenTShirt() {
		UIKeyword.click(menTShirt);

	}
	
	public void searchProduct(String productName) {
		UIKeyword.enterText(searchComponent, productName);
		UIKeyword.hitButton(KeyEvent.VK_ENTER);

	}

	public void clickOnCasualShirts() {
		casualShirts.click();
		//System.out.println("Clicked on Casual Shirts");
		log.info("Clicked on Casual Shirts");
		
		
	}
	
	public List<String> getSearchResultTexts() {
		List<String> productexts = new ArrayList<String>();
		for (WebElement product :this.productTexts) {
			productexts.add(product.getText());
			
		}	
		
		return productexts;

	}
	
	
}
