package com.iris22a;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.CasualShirtsPage;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;
import com.iris22a.util.PropUtil;
import com.iris22a.util.WaitFor;


public class ProductTests extends TestBase {
	private static final Logger log = Logger.getLogger(ProductTests.class);
	@Test
	public void verifySearchResultForPoloMen() {
		PropUtil repository = new PropUtil();
		UIKeyword.launchurl(Environment.URL);
		UIKeyword.enterText(repository.getLocator("search_Products_txtBx")[0],repository.getLocator("search_Products_txtBx")[1], "polo Men");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeyword.getTexts(repository.getLocator("product_titles_txt")[0],repository.getLocator("product_titles_txt")[1]);
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"),"Product title doesn't contains pol: "+productTitle);	
		}
	}
	
	@Test
	public void verifyCategoryListForTopWears() {
		List<String> expected = new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Kurtas");
		expected.add("Sweatshirts");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");
		PropUtil repository = new PropUtil();
		UIKeyword.launchurl(Environment.URL);
		UIKeyword.mouseMove(repository.getLocator("men_menu")[0],repository.getLocator("men_menu")[1]);
		UIKeyword.click(repository.getLocator("men_topwear")[0],repository.getLocator("men_topwear")[1]);
		WaitFor.elementToBePresent(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		List<String> actualcategories =UIKeyword.getTexts(repository.getLocator("categories_text")[0],repository.getLocator("categories_text")[1]);
		for (int i=0; i<actualcategories.size(); i++) {
			actualcategories.set(i,actualcategories.get(i).split("\\(")[0]);	
		}
		//System.out.println(actualcategories);
		log.info(actualcategories);
		Assert.assertTrue(actualcategories.containsAll(expected),"List didn't mathch: expected: "+expected+"\n Actual:"+actualcategories);
	}
	
	@Test
	private void VerifyItemCountOfCasualShirts() {
		UIKeyword.launchurl(Environment.URL);
		HomePage home =new HomePage();
		home.hoverOnMenMenu();
		home.clickOnCasualShirts();
		CasualShirtsPage casual = new CasualShirtsPage();
		int itemCount = casual.getItemCount();
		//System.out.println(itemCount);
		log.info(itemCount);
		

	}
}


