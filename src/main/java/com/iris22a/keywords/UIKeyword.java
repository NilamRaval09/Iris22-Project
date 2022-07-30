package com.iris22a.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword {
	public static RemoteWebDriver driver;
	public static final Logger log =Logger.getLogger(UIKeyword.class);

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito","start-maximized","--disable-notification");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		//System.out.println(browserName + " browser is launched successfully");
		log.info(browserName + " browser is launched successfully");
	}

	public static void launchurl(String url) {
		driver.get(url);
		//System.out.println("Url is launched: " + url);
		log.info("Url is launched: " + url);
		
	}

	public static void closeBrowser() {
		driver.close();
		//System.out.println("Browser is closed successfully");
		log.info("Browser is closed successfully");
	}

	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
				System.out.println("Switched on window: " + byTitle);
				break;
			}

		}

	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}

	public static void hitButton(int keyCode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			log.error("Unable to instantiate Robot class instance");
		}
		robo.keyPress(keyCode);
		robo.keyRelease(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement ele : elements) {
			texts.add(ele.getText());
		}

		return texts;
	}
	public static void mouseMove(By xpath) {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();

	}
	public static void click(By xpath) {
		driver.findElement(xpath).clear();
	}
	public static void click(String locatorType,String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if(locatorType.equals("xpath")) {
			element=driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equals("id")) {
			element=driver.findElement(By.id(locatorValue));
		}else if(locatorType.equals("css")) {
			element=driver.findElement(By.cssSelector(locatorValue));
		}else if(locatorType.equals("name")) {
			element=driver.findElement(By.name(locatorValue));
		}else if(locatorType.equals("className")) {
			element=driver.findElement(By.className(locatorValue));
		}else if(locatorType.equals("linkText")) {
			element=driver.findElement(By.linkText(locatorValue));
		}else if(locatorType.equals("partialLinkText")) {
			element=driver.findElement(By.partialLinkText(locatorValue));
		}else if(locatorType.equals("tagName")) {
			element=driver.findElement(By.tagName(locatorValue));
		}else {
			//System.err.println("Invalid locator type: "+locatorType);
			log.error("Invalid locator type: "+locatorType);
		}
		return element;

	}
	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if(locatorType.equals("xpath")) {
			elements=driver.findElements(By.xpath(locatorValue));
		}else if(locatorType.equals("id")) {
			elements=driver.findElements(By.id(locatorValue));
		}else if(locatorType.equals("css")) {
			elements=driver.findElements(By.cssSelector(locatorValue));
		}else if(locatorType.equals("name")) {
			elements=driver.findElements(By.name(locatorValue));
		}else if(locatorType.equals("className")) {
			elements=driver.findElements(By.className(locatorValue));
		}else if(locatorType.equals("linkText")) {
			elements=driver.findElements(By.linkText(locatorValue));
		}else if(locatorType.equals("partialLinkText")) {
			elements=driver.findElements(By.partialLinkText(locatorValue));
		}else if(locatorType.equals("tagName")) {
			elements=driver.findElements(By.tagName(locatorValue));
		}else {
			//System.err.println("Invalid locator type: "+locatorType);
			log.error("Invalid locator type: "+locatorType);
		}
		return elements;
	}
	public static void mouseMove(String locatorType, String locatorValue) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(getWebElement(locatorType, locatorValue)).perform();
	}
	

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<WebElement> elements=getWebElements(locatorType, locatorValue);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
			
		}
		return texts;
	}

	public static void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
		
	}

	public static void mouseMove(WebElement element) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(element).perform();

		
	}

	public static void click(WebElement element) {
		element.click();
		
	}

	public static void enterText(WebElement element, String productName) {
		element.sendKeys(productName);
		 
		
	}
		
}
