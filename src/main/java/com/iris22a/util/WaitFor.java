package com.iris22a.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.iris22a.keywords.UIKeyword;

public class WaitFor {
	
	private static FluentWait<WebDriver> wait =null;
	
	static{
		wait=new FluentWait<WebDriver>(UIKeyword.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofSeconds(1000));
		wait.withMessage("Wait is finished and element is not laoded or available");
	}
	
	public static void elementToBePresent(By locator) {
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void elementToBePresent(String locatorTpe, String locatorValue) {
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);

	}
	
}