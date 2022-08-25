package com.iris22a.config;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keywords.UIKeyword;

import io.cucumber.java.After;

public class TestBase {
	private static final Logger log = Logger.getLogger(TestBase.class);
	
	/*@Parameters("browser-name")
	@BeforeClass  //testng
	public void setUp(@Optional String browseName) throws Exception {*/
	
	/*@Before
	public void setUp(String browseName) throws Exception{
		String brwsName = System.getProperty("browser");
		String browserName = Environment.BROWSER;
		if(browseName==null) {
			browseName="Chrome";
		}
		if(browseName.isEmpty()) {
			browseName="Chrome";
			//System.out.println("default browser is Chrome");
			log.info("default browser is Chrome");
		}
		
		UIKeyword.openBrowser(browseName);
	}*/
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName) {
		UIKeyword.openBrowser(browserName);
	}
	
	//@AfterClass
	@After
	public void tearDown() throws Exception {
		UIKeyword.closeBrowser();
		log.info("Browser is close successfully");
		
	}


}
