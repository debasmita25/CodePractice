package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnderstandingLocators {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.zoho.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		List<WebElement> eleLinks=driver.findElements(By.cssSelector("a[href]"));
		System.out.println("Total links : "+eleLinks.size());
		
		for(WebElement ele:eleLinks)
		{
			if(ele.getText().equals("Sign In"))
			{
				ele.click();
				break;
			}
		}
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		WebElement eleLink=driver.findElement(By.linkText("Sign In"));
		eleLink.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		WebElement elePartLink=driver.findElement(By.partialLinkText("Sign"));
		elePartLink.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
	}

}
