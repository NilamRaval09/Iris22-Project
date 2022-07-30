package com.iris22a.stepdefinition;

import java.util.List;

import org.testng.Assert;

import com.iris22a.keywords.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	@Given("chrome browser is open")
	public void m1() {
		UIKeyword.openBrowser("Chrome");

	}
	
	@And("url is launched")
	public void launchMyntraUrl() {
		UIKeyword.launchurl(Environment.URL);

	}
	
	@When("user searches for polo t shirt")
	public void searchPoloTShirt() {
		HomePage home = new HomePage();
		home.searchProduct("Polo");

	}
	
	@Then("all results should be realted to polo")
	public void verifyAllResults() {
		HomePage home = new HomePage();
	List<String> productTexts =	home.getSearchResultTexts();
	for (String text : productTexts) {
		Assert.assertTrue(text.toLowerCase().contains("polo"),"Product is mismatched: "+text);
		
	}
	
	
	

	}

}
