package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keywords.UIKeyword;

public class MenTShirtPage {
	
	@FindBy(xpath="//div[@class='sort-sortBy']")
	public WebElement sortByFilter;
	
	/*@FindBy(xpath="//h4[@class='atsa-title'])[2]")
	public WebElement countryOfOrigin;*/
	
	@FindBy(xpath="//*[contains(text(),'Popularity')]")
	public WebElement popularityFilter;
	
	/*public MenTShirtPage() { //initialization using constructor
		sortByFilter = UIKeyword.driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		countryOfOrigin = UIKeyword.driver.findElement(By.xpath("(//h4[@class='atsa-title'])[2]"));
		popularityFilter =UIKeyword.driver.findElement(By.xpath("//*[contains(text(),'Popularity')]"));
	}*/
	
	public MenTShirtPage() {
		PageFactory.initElements(UIKeyword.driver, this);//pagefactory initialized using constructor
		
	}
	
	public void ClickOnSortByFilter() {
		sortByFilter.click();

	}
	public void selectPopularityFilter() {
		UIKeyword.mouseMove(sortByFilter);
		UIKeyword.click(popularityFilter);
	}
	
	public void selectWhatsNewFilter() {
		

	}
	public void selectBetterDiscountFilter() {

	}
		
	

}
