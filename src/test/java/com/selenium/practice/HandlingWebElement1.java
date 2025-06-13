package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
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

	@Test
	public void iframeExample()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//form[@id='id3']/.."))));
        //ele.sendKeys("Hello Debasmita");
        
		
	}

}
