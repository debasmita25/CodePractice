package com.selenium.practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		Wait fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-mm-yy hh:mm:ss");
		System.out.println(df.format(lt));
		try {
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// WebElement newtabBtn = driver.findElement(By.xpath("//button[text()='New
			// Tab']"));
			
			  //WebElement ele =wait.until(ExpectedConditions. presenceOfElementLocated(By.xpath("//button[text()='New // Tab']")));
			 			
			

			WebElement element = (WebElement) fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					try {
						WebElement ele = driver.findElement(By.id("username"));
						if (ele.isDisplayed()) {
							return ele;
						} else {
							return null; // keep polling
						}
					} catch (NoSuchElementException e) {
						return null; // element not found yet, keep polling
					}
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			lt = LocalDateTime.now();
			System.out.println(df.format(lt));
		}

		finally {
			driver.close();
		}
	}

}
