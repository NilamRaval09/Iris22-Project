package com.iris22a;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTShirtPage;
import com.iris22a.util.Environment;

//public class  MenTshirtsTests extends TestBase
	public class MenTshirtsTests{//in cucumber no need to extend TestBase class
	UIKeyword keyword = new UIKeyword();
	
	@Test
	public void verifyIfSearchByPopularityYieldsProperResults() {
		UIKeyword.launchurl(Environment.URL);
		//HomePage home = new HomePage();
		//HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);//object created using pagefactory class
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		home.clickOnMenTShirt();
		
		//MenTShirtPage menTShirt = new MenTShirtPage();
		//MenTShirtPage menTShirt = PageFactory.initElements(UIKeyword.driver, MenTShirtPage.class); or
		MenTShirtPage menTShirt = new MenTShirtPage();//constructor called
		menTShirt.ClickOnSortByFilter();
		menTShirt.selectPopularityFilter();
		

	
	
	}
	              
}
                   