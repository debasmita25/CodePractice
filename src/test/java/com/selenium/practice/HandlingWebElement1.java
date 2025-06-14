package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingWebElement1 {

	WebDriverWait wait;

	// @Test
	public void testAuthenticationPopUp() {

		WebDriver driver = new ChromeDriver();

		// Authentication pop up
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		WebElement textPresent = driver.findElement(By.cssSelector("div[id='content'] p"));
		Assert.assertEquals(textPresent.getText(), "Congratulations! You must have the proper credentials.");

	}

	// @Test
	public void iframeExample() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//frame[@src='frame_3.html']"))));
		WebElement ele = driver.findElement(By.name("mytext3"));

		ele.sendKeys("Hello Debasmita");
		System.out.println(driver.findElement(By.tagName("iframe")).getAttribute("src"));
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//frame[@src='frame_2.html']"))));
		ele = driver.findElement(By.name("mytext2"));

		ele.sendKeys("Hello Sudeep");
	}

	// @Test
	// StaleElementReferenceException
	public void autoSuggest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selen");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> autoSuggestions = (List<WebElement>) js
				.executeScript("return document.querySelectorAll('ul li');");
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[class*='sbct
		// PZPZlf']")));
		System.out.println(autoSuggestions.size());

		for (int i = 0; i < autoSuggestions.size(); i++) {
			String autoSuggestion = autoSuggestions.get(i).getText();
			System.out.println(autoSuggestion);
			if (autoSuggestion.equalsIgnoreCase("Selenium")) {
				try {
					autoSuggestions.get(i).click();
					break;
				} catch (Exception e) {
					autoSuggestions = (List<WebElement>) js.executeScript("return document.querySelectorAll('ul li');");
					autoSuggestions.get(i).getText();
					break;
				}
			}
		}

	}

	//@Test
	public void dynamicButton() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele = driver.findElement(By.cssSelector("div[class='widget-content'] button[onclick*='toggle']"));
		System.out.println(ele.getAttribute("name"));
		try {
			ele.click();
			System.out.println(ele.getAttribute("name"));
		} catch (Exception e) {
			ele = driver.findElement(By.cssSelector("div[class='widget-content'] button[onclick*='toggle']"));
			ele.click();
			System.out.println(ele.getAttribute("name"));
		}

	}

}
